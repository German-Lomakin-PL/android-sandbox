package com.sandbox.data

import com.sandbox.data.dto.Chat
import kotlinx.coroutines.flow.Flow


interface SandboxRepository {
    fun getChats(): Flow<List<Chat>>
}