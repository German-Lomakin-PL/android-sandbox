package com.example.androidsandbox.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidsandbox.R
import com.example.androidsandbox.main.model.MainUIState
import com.example.androidsandbox.main.model.Message
import com.example.androidsandbox.mocks.MockData
import com.example.androidsandbox.modules.ResourceProvider
import com.sandbox.data.SandboxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val repository: SandboxRepository,
) : ViewModel() {

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

            _messages.clear()
            repository.getChats()
                .flowOn(Dispatchers.IO)
                .catch { Log.i("FPS", "Error: $it") }
                .collect {
                    it.forEach { chat ->
                        _messages.add(
                            Message(
                                chat.name,
                                chat.avatar,
                                resourceProvider.getString(R.string.chat_card_messages),
                                chat.createdAt
                            )
                        )
                    }
                }

            _isRefreshing = false
            updateState()
        }
    }

    private suspend fun updateState() {
        _uiState.emit(MainUIState(_username, _messages, _isRefreshing))
    }
}