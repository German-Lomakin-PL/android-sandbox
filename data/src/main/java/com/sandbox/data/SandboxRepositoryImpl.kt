package com.sandbox.data

import com.sandbox.data.dto.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class SandboxRepositoryImpl(private val api: SandboxApi) : SandboxRepository {

    override fun getChats(): Flow<List<Chat>> = flow {
        emit(api.getChats())
    }

}
