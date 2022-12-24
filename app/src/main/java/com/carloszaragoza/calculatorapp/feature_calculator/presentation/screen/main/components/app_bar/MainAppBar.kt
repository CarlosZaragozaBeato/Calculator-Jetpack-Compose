package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.app_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainAppBar(
    checked: Boolean,
    onChangeTheme: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        title = {
            Text("calc",
                fontSize = 30.sp,
                color = MaterialTheme.colors.primaryVariant)
        },
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("THEME",
                    color = MaterialTheme.colors.primaryVariant)
                Switch(
                    checked = checked,
                    colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colors.onPrimary),
                    modifier = Modifier.padding(8.dp),
                    onCheckedChange = { onChangeTheme.invoke() }
                )
            }

        }
    )
}