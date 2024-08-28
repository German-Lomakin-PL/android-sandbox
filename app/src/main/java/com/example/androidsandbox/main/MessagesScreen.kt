package com.example.androidsandbox.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

@Composable
fun MessagesScreen(username: String, messages: List<Message>) {

    AndroidSandboxTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            topBar = { MessagesActionbar(username = username) }) { contentPadding ->

            Column(Modifier.padding(contentPadding)) {
                MessageList(messages)
            }
        }
    }

}