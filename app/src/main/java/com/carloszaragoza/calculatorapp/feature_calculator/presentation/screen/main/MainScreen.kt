package com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.app_bar.MainAppBar
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.body.CalculatorKeys
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.components.body.CalculatorPanel
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.screen.main.util.CalculatorEvents
import com.carloszaragoza.calculatorapp.feature_calculator.presentation.util.UiEvent

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{event->
            when(event){
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message)
                }
            }
        }
    }




    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                checked = viewModel.state.currentTheme,
                onChangeTheme = {viewModel.onEvent(CalculatorEvents.ChangeTheme)})
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CalculatorPanel(outputNumber = viewModel.currentNumber)

            CalculatorKeys(
                onAddEspecial = { especial ->
                    viewModel.onEvent(CalculatorEvents.EnterEspecial(especial))
                },
                onCalculate = { viewModel.onEvent(CalculatorEvents.Calculate)},
                onNumberEntered = { number ->
                    viewModel.onEvent(CalculatorEvents.EnterNumber(number))
                },
                onSymbolEntered = { symbol ->
                    viewModel.onEvent(CalculatorEvents.EnterOperation(symbol))
                },
            )

        }
    }
}