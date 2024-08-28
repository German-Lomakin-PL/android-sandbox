package com.example.androidsandbox.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val messages = listOf(
            Message(
                "Arthur",
                "What's up dude? Should we go for a walk tonight?",
                "15:32"
            ),
            Message(
                "German",
                "Hey! Let's go to the beach",
                "15:34"
            ),
            Message(
                "Arthur",
                "For sure! Meet you there",
                "16:02"
            )
        )

        setContent {
            AndroidSandboxTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()) {
                    MessagesScreen("Arthur", messages)
                }
            }
        }
    }
}

