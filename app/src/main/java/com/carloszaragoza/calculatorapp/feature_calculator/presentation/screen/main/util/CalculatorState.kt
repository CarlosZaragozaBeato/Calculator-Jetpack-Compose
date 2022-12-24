package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.util

data class CalculatorState(
    var firstNumber:String = "",
    var secondNumber:String = "",
    var operation: String = "",
    val currentTheme:Boolean = true,
    val outputNumber:String = ""
)
