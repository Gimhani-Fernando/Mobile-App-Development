package com.gimhani.android.driver2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            Greeting("Gimhani")
            Greeting("Android")
            Button(onClick = {
                Log.d("TwoGreetings","You clicked")
            }){
                Text(text = "Click on this")
            }
        }
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