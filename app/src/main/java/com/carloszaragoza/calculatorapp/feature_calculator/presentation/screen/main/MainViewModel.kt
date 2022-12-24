package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.util.CalculatorEvents
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.util.CalculatorState
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class MainViewModel(): ViewModel(){

    var state by mutableStateOf(CalculatorState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var currentNumber by mutableStateOf("")

    fun onEvent(event: CalculatorEvents){
        when (event){
            is CalculatorEvents.ChangeTheme -> {
                state = state.copy(
                    currentTheme = !state.currentTheme
                )
            }
            is CalculatorEvents.EnterNumber -> {
                numberEntered(event.number)
            }
            is CalculatorEvents.EnterOperation -> {
                enterOperations(event.operation)
            }
            is CalculatorEvents.EnterEspecial -> {
                especials(event.especial)
            }
            is CalculatorEvents.Calculate -> {
                operations()
            }
        }
    }

    private fun enterOperations(operation:String){
        if(state.operation.isBlank()){
            state.operation = operation
            currentNumber += operation
        }
        if(state.outputNumber.isNotBlank()){
            state = state.copy(
                operation = operation,
                firstNumber = state.outputNumber,
                secondNumber = "",
                outputNumber = "")

            currentNumber +=operation
        }
    }

    private fun operations(){
        if(state.secondNumber.isNotBlank()){
            when(state.operation){
                "+" -> {
                    currentNumber = (state.firstNumber.toDouble() + (state.secondNumber.toDouble())).toString()
                    state = state.copy(outputNumber = currentNumber)
                }
                "-" -> {
                    currentNumber = (state.firstNumber.toDouble() - (state.secondNumber.toDouble())).toString()
                    state = state.copy(outputNumber = currentNumber)
                }
                "/" -> {
                    currentNumber = (state.firstNumber.toDouble() / (state.secondNumber.toDouble())).toString()
                    state = state.copy(outputNumber = currentNumber)
                }
                "*" -> {
                    currentNumber = (state.firstNumber.toDouble() * (state.secondNumber.toDouble())).toString()
                    state = state.copy(outputNumber = currentNumber)
                }
            }
        }
    }

    private fun numberEntered(number:String){
        if(state.outputNumber.isNotBlank()){
            resetCalculator()
        }
        if(currentNumber.length <= 35) {
            if(state.operation.isBlank()){
                if(number != "."){
                    state.firstNumber += number
                    currentNumber += number
                }else if(number == "." && !state.firstNumber.contains(".")){
                    state.firstNumber += number
                    currentNumber += number
                }

            }else{
                if(number != "."){
                    state.secondNumber += number
                    currentNumber += number
                }else if(number == "." && !state.secondNumber.contains(".")){
                    state.secondNumber += number
                    currentNumber += number
                }
            }

        }else{
            currentNumber = currentNumber.dropLast(1)
            sendUiEvent(UiEvent.ShowSnackBar(
                message = "Please enter less than 35 numbers..."
            ))

        }
    }

    private fun resetCalculator(){
        currentNumber = ""
        state = state.copy(
            operation = "",
            firstNumber = "",
            secondNumber = "",
            outputNumber = ""
        )
    }
    private fun especials(especial:String){
        if(especial == "RESET"){
            resetCalculator()
        }
        if(especial =="DEL"){

            if(state.secondNumber.isBlank() && state.operation.isNotBlank()){
                state =  state.copy(
                    operation = ""
                )
            }
            if(state.secondNumber.isNotBlank()){
                state = state.copy(
                    secondNumber = state.secondNumber.dropLast(1)
                )
            }
            if(state.operation.isBlank()){
                state = state.copy(
                    firstNumber = state.firstNumber.dropLast(1)
                )
            }
            currentNumber = currentNumber.dropLast(1)
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch{
            _uiEvent.send(event)
        }
    }

}