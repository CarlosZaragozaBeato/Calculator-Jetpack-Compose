package com.carloszaragoza.calculatorapp.feature_calculator.domain.model

class Key (
    val key: String,
    val type:String){

        companion object {
            val listOfKeys= listOf(
                Key(
                    key = "7",
                    type= "number"
                ),
                Key(
                    key = "8",
                    type= "number"
                ),
                Key(
                    key = "9",
                    type= "number"
                ),
                Key(
                    key = "DEL",
                    type= "ESPECIAL"
                ),
                Key(
                    key = "4",
                    type= "number"
                ),
                Key(
                    key = "5",
                    type= "number"
                ),
                Key(
                    key = "6",
                    type= "number"
                ),
                Key(
                    key = "+",
                    type= "OPERATION"
                ),
                Key(
                    key = "1",
                    type= "number"
                ),
                Key(
                    key = "2",
                    type= "number"
                ),
                Key(
                    key = "3",
                    type= "number"
                ),
                Key(
                    key = "-",
                    type= "OPERATION"
                ),
                Key(
                    key = ".",
                    type= "number"
                ),
                Key(
                    key = "0",
                    type= "number"
                ),
                Key(
                    key = "/",
                    type= "OPERATION"
                ),
                Key(
                    key = "*",
                    type= "OPERATION"
                ),
            )
            val listOfEspecial = listOf(
                Key(
                    key = "RESET",
                    type= "ESPECIAL"
                ),
                Key(
                    key = "=",
                    type= "RESULT"
                ),
            )
        }
}
