package com.example.androidsandbox.main.model

data class MainUIState(val username: String, val messages: List<Message>, val isRefreshing: Boolean = false)