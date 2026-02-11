package com.example.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CalculatorUi( viewModel: CalculatorViewModel ) {
    val state by viewModel.state.collectAsStateWithLifecycle()

//    val calculator : Calculator= CalculatorImpl()

//    var num1 by remember { mutableStateOf("") }
//    var num2 by remember { mutableStateOf("") }
//    var result by remember { mutableStateOf(0) }

//    var num1Error by remember { mutableStateOf("") }
//    var num2Error by remember { mutableStateOf("") }

    Column(modifier= Modifier
        .fillMaxSize()
        .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Calculator App", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = state.num1,
            onValueChange = {viewModel.updateNum1(it)},
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number)
        )
        Text("${state.num1Error}")
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            listOf("+", "-", "*", "/").forEach { op ->
                Text(
                    text = op,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp)
                        .clickable { viewModel.selectOperator(op) },
                    fontWeight = if (state.operator==op) FontWeight.Bold else FontWeight.Normal
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = state.num2,
            onValueChange = {viewModel.updateNum2(it)},
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number)
        )
        Text("${state.num2Error}")

        Spacer(modifier = Modifier.height(20.dp))

        Text(text="${state.result}")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { viewModel.calculate() }) {
            Text("Add")
        }

    }
}