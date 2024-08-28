package com.example.androidsandbox.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

@Composable
fun MessagesScreen(username: String, messages: List<Message>) {

    AndroidSandboxTheme {
        Surface(contentColor = MaterialTheme.colorScheme.background) {
            Scaffold(
                contentColor = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxSize().systemBarsPadding(),
                topBar = { MessagesActionbar(username = username) }) { contentPadding ->

                Column(Modifier.padding(contentPadding)) {
                    MessageList(messages)
                }
            }
        }
    }

}