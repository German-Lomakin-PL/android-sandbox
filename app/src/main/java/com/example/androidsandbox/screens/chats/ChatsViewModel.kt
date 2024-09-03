package com.example.androidsandbox.screens.chats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsandbox.mocks.ChatsMockData
import com.example.androidsandbox.screens.chats.model.Chat
import com.example.androidsandbox.screens.chats.model.ChatsUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class ChatsViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ChatsUIState(emptyList(), false))
    val uiState: StateFlow<ChatsUIState> = _uiState.asStateFlow()

    private val _chats = ArrayList<Chat>()
    private var _isRefreshing = false

    init {
        refresh()
    }

    fun refresh() {
        if (_isRefreshing) return

        _isRefreshing = true
        _uiState.value = ChatsUIState(_chats, _isRefreshing)
        viewModelScope.launch {
            delay(2000)
            if (_chats.isEmpty()) {
                _chats.addAll(ChatsMockData.chats)
            } else {
                _chats.add(ChatsMockData.chats[Random.nextInt(0, ChatsMockData.chats.size)])
            }
            _isRefreshing = false
            updateState()
        }
    }

    private suspend fun updateState() {
        _uiState.emit(ChatsUIState(_chats, _isRefreshing))
    }
}