package com.example.androidsandbox.screens.chats.model

data class ChatsUIState(val chatList: List<Chat>, val isRefreshing: Boolean = false)