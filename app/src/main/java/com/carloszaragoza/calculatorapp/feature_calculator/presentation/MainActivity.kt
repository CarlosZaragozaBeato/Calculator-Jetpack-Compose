package com.carloszaragoza.calculatorapp.feature_calculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.MainScreen
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.MainViewModel
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()

            CalculatorAppTheme(
                darkTheme = viewModel.state.currentTheme
            ) {
              MainScreen(viewModel = viewModel)
            }
        }
    }
}
