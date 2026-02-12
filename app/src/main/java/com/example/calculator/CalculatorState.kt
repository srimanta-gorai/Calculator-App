package com.example.calculator

data class CalculatorState(
    val num1: String = "",
    val num2: String = "",
    val num1Error: String = "",
    val num2Error: String = "",
    val result: String = "",
    val operator: List<String> = emptyList(),
//    val operator : String = "",
    val selectOperator : String = ""
)
