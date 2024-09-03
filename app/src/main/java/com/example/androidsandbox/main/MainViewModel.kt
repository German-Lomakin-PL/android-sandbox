package com.example.androidsandbox.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsandbox.main.model.MainUIState
import com.example.androidsandbox.main.model.Message
import com.example.androidsandbox.mocks.MockData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MainUIState("", emptyList(), false))
    val uiState: StateFlow<MainUIState> = _uiState.asStateFlow()

    private val _username = MockData.username
    private val _messages = ArrayList<Message>()
    private var _isRefreshing = false

    init {
        refresh()
    }

    fun refresh() {
        if (_isRefreshing) return

        _isRefreshing = true
        _uiState.value = MainUIState(_username, _messages, _isRefreshing)
        viewModelScope.launch {
            delay(2000)
            if (_messages.isEmpty()) {
                _messages.addAll(MockData.messages)
            } else {
                _messages.add(MockData.messages[Random.nextInt(0, MockData.messages.size)])
            }
            _isRefreshing = false
            updateState()
        }
    }

    private suspend fun updateState() {
        _uiState.emit(MainUIState(_username, _messages, _isRefreshing))
    }
}