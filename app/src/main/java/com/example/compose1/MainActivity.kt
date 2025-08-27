package com.example.compose1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingListView()
        }
    }
}

@Composable
fun GreetingListView(modifier: Modifier = Modifier) {
    val greetingStateList = remember { mutableStateListOf<String>("Sani") }
    val textfieldValue = remember { mutableStateOf(value = "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingList(
            greetingStateList,
            textfieldValue.value,
            onClick = {
                greetingStateList.add(textfieldValue.value)
            }, onTextChange = {
                textfieldValue.value = it
            })
    }
}

@Composable
fun GreetingList(
    names: List<String>,
    textfieldVal: String,
    onClick: () -> Unit,
    onTextChange: (name: String) -> Unit
) {
    for (name in names) {
        Greeting(name)
    }
    TextField(value = textfieldVal, onValueChange = { value -> onTextChange(value) })
    Button(onClick = onClick) {
        Text(text = "Add new name")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name")
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HorizontalColorBar(Color.Red)
                HorizontalColorBar(Color.Blue)
            }
            HorizontalColorBar(Color.Magenta)
            HorizontalColorBar(Color.Yellow)
            HorizontalColorBar(Color.Green)
        }
    }
}

@Composable
fun HorizontalColorBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) { }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingListView()
}