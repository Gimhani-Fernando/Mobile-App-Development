package com.gimhani.android.driver2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.gimhani.android.driver2.services.Calculate
import com.gimhani.android.driver2.services.HelloMessageService
import com.gimhani.android.driver2.ui.theme.SENG22243_MobileApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SENG22243_MobileApplicationTheme {
                TwoGreetings()
            }
        }
    }
}

@Composable
fun TwoGreetings(){
    //variables
    var number1 by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0,7)))
    }

    var number2 by rememberSaveable(stateSaver = TextFieldValue.Saver){
        mutableStateOf(TextFieldValue("", TextRange(0,7)))
    }

    var total by remember {
        mutableStateOf(0)
    }

    var calculate = Calculate()

    //Assignment variables
    var name by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0,7)))
    }

    var age by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0,7)))
    }

    var helloText by remember {
        mutableStateOf("")
    }

    var helloMessageService = HelloMessageService()
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(){
            OutlinedTextField(
                value = number1,
                onValueChange = {number1 = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) ,
                label = { Text("Number 1")}
            )
            OutlinedTextField(
                value = number2,
                onValueChange = {number2 = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) ,
                label = { Text("Number 2")}
            )

            Text(text = "Total is $total")

            Button(onClick = {
                total = calculate.add(number1.text.toInt() , number2.text.toInt())
            }){
                Text(text="Add")
            }


            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text("Name")}
            )

            OutlinedTextField(
                value = age,
                onValueChange = {age = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("age")}
            )

            Text(text = helloText)
            Button(onClick = {
                helloText = helloMessageService.compose(name.text,age.text)
            }) {
                Text(text = "Click")
            }
        }

//        Column() {
//            Greeting("Gimhani")
//            Greeting("Android")
//            Button(onClick = {
//                Log.d("TwoGreetings","You clicked")
//            }){
//                Text(text = "Click on this")
//            }
//        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! welcome")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLight() {
    SENG22243_MobileApplicationTheme {
        Greeting("Gimhani")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewDark() {
    SENG22243_MobileApplicationTheme(darkTheme = false) {
        Greeting("Android")
    }
}