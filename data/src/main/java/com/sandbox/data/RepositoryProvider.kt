package com.sandbox.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitBuilder {

    private const val BASE_URL = "https://66e81788b17821a9d9db5466.mockapi.io/sandbox/api/"

    fun create(): SandboxApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SandboxApi::class.java)
    }

}

object RepositoryProvider {
    fun provide(): SandboxRepository {
        return SandboxRepositoryImpl(RetrofitBuilder.create())
    }
}