package com.example.androidsandbox.main.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidsandbox.main.MainViewModel
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

@Composable
fun MessagesScreen(mainViewModel: MainViewModel = viewModel()) {
    val mainUIState = mainViewModel.uiState.collectAsState().value

    AndroidSandboxTheme {
        Surface(contentColor = MaterialTheme.colorScheme.background) {
            Scaffold(
                contentColor = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxSize().systemBarsPadding(),
                topBar = { MessagesActionbar(username = mainUIState.username) }) { contentPadding ->

                Column(Modifier.padding(contentPadding)) {
                    MessageList(mainUIState.messages, mainUIState.isRefreshing) { mainViewModel.refresh() }
                }
            }
        }
    }
}