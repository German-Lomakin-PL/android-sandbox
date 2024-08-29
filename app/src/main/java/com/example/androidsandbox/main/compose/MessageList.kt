package com.example.androidsandbox.main.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidsandbox.main.model.Message
import com.example.androidsandbox.widgets.PullToRefreshLazyColumn

@Composable
fun MessageList(messages: List<Message>, isRefreshing: Boolean, onRefresh: () -> Unit) {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            PullToRefreshLazyColumn(
                listItems = messages,
                isRefreshing = isRefreshing,
                onRefresh = onRefresh,
                content = { message ->
                    MessageCard(message)
                }
            )
        }
}
