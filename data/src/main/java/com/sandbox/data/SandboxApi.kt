package com.sandbox.data

import com.sandbox.data.dto.Chat
import retrofit2.http.GET

internal interface SandboxApi {
    @GET("/chats")
    suspend fun getChats(): List<Chat>
}