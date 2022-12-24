package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.util

sealed class CalculatorEvents{
    data class EnterNumber(val number: String):CalculatorEvents()
    data class EnterOperation(val operation:String):CalculatorEvents()
    data class EnterEspecial(val especial: String):CalculatorEvents()
    object Calculate: CalculatorEvents()
    object ChangeTheme: CalculatorEvents()
}
