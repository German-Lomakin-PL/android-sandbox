package com.example.androidsandbox.di

import android.content.Context
import com.example.androidsandbox.modules.ResourceProvider
import com.example.androidsandbox.modules.ResourceProviderImpl
import com.sandbox.data.RepositoryProvider
import com.sandbox.data.SandboxRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModules {
    @Provides
    @Singleton
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideRepository(): SandboxRepository {
        return RepositoryProvider.provide()
    }
}
