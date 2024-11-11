package com.chani.litegridcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.chani.litegridcompose.LiteGrid
import com.chani.litegridcomposesample.ui.theme.LiteGridComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiteGridComposeSampleTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val list = remember { mutableListOf("사과", "딸기", "바나나", "자두", "복숭아") }

    LiteGrid(
        modifier = Modifier,
        columns = 3,
        horizontalCenterAlignment = true,
    ) {
        list.forEach {
            Text(text = it, modifier = Modifier.fillMaxSize())
        }
    }
}