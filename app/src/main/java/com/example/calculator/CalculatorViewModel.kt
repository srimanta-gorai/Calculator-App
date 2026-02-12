package com.example.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CalculatorViewModel: ViewModel(){

    private val _state = MutableStateFlow(CalculatorState())
    val state = _state.asStateFlow()

    fun updateNum1(num : String) {
        _state.update { it.copy(num1 = num) }
    }

    fun updateNum2(num : String) {
        _state.update { it.copy(num2 = num) }
    }

    fun selectOperator(op: String) {
        _state.update { it.copy(selectOperator = op) }
    }

    init {
        _state.update {
            it.copy(
                operator = listOf("+","-","*","/")
//                operator = emptyList()
            )
        }
    }

    fun calculate() {

        val n1 = _state.value.num1.toFloatOrNull() ?: 0f
        val n2 = _state.value.num2.toFloatOrNull() ?: 0f
        val op = _state.value.selectOperator

        val result = when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> if (n2 != 0f) n1 / n2 else 0f
            else -> 0f

        }

        _state.update { it.copy(result=result.toString()) }

    }

}