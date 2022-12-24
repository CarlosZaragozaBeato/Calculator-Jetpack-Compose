package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.body

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.theme.LocalSpacing

@Composable
fun CalculatorPanel(
    outputNumber:String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .padding(top= LocalSpacing.current.medium, start = LocalSpacing.current.medium,
                end = LocalSpacing.current.medium, bottom = LocalSpacing.current.small)

    ){
        TextField(value = outputNumber,
            onValueChange = {},
            enabled = false,
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                textColor = MaterialTheme.colors.primaryVariant
            ),
            maxLines = 2,
            textStyle = TextStyle(
                fontSize = 30.sp,
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .fillMaxWidth())
    }
}