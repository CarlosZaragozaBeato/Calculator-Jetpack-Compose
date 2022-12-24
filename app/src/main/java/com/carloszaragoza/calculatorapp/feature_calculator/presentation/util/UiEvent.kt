package com.carloszaragoza.calculatorapp.feature_calculator.presentation.util

sealed class UiEvent{
    data class ShowSnackBar(val message:String): UiEvent()
}
