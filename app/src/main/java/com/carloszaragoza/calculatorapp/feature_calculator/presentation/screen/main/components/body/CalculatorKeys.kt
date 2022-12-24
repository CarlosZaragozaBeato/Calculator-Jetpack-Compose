package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.body

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carloszaragoza.calculatorapp.feature_calculator.domain.model.Key
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.theme.LocalSpacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalculatorKeys(
    onAddEspecial:(String) -> Unit,
    onNumberEntered:(String) -> Unit,
    onCalculate: () -> Unit,
    onSymbolEntered:(String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp


    Column(
        modifier = Modifier
            .height((screenHeight/1.4).dp)
            .padding(LocalSpacing.current.small)
            .background(MaterialTheme.colors.onBackground)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        LazyVerticalGrid(cells = GridCells.Fixed(4),
            modifier = Modifier
                .padding(LocalSpacing.current.small)
                .height(350.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            items(Key.listOfKeys){ item->
                Surface(
                    modifier = Modifier
                        .padding(LocalSpacing.current.small)
                        .size(70.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    color = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                when (item.type) {
                                    "ESPECIAL" -> onAddEspecial.invoke(item.key)
                                    "OPERATION" -> onSymbolEntered.invoke(item.key)
                                    else -> onNumberEntered.invoke(item.key)
                                }
                            }
                            .clip(RoundedCornerShape(5.dp))
                            .background(
                                if (item.type == "ESPECIAL")
                                    MaterialTheme.colors.secondary
                                else
                                    MaterialTheme.colors.primary
                            ),
                        contentAlignment = Alignment.Center,

                        ){
                        Text(item.key,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = if(item.type =="ESPECIAL")
                                            MaterialTheme.colors.primary
                                        else
                                            MaterialTheme.colors.onBackground,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            modifier = Modifier
                .height(120.dp)
                .padding(LocalSpacing.current.small)){
            items(Key.listOfEspecial){ especial->

                Surface(
                    modifier = Modifier
                        .padding(LocalSpacing.current.small)
                        .fillMaxWidth()
                        .height(70.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    color = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                if (especial.type == "ESPECIAL")
                                    onAddEspecial.invoke(especial.key)
                                else
                                    onCalculate.invoke()
                            }
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (especial.type == "ESPECIAL")
                                    MaterialTheme.colors.secondary
                                else
                                    MaterialTheme.colors.onPrimary
                            ),
                        contentAlignment = Alignment.Center,

                        ){
                        Text(especial.key,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = MaterialTheme.colors.primaryVariant,
                                fontWeight = FontWeight.Bold)
                        )

                    }
                }
            }
        }
    }
}