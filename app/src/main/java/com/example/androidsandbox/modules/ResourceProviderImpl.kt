package com.example.androidsandbox.modules

import android.content.Context

class ResourceProviderImpl(private val appContext: Context) : ResourceProvider {
    override fun getString(resId: Int): String = appContext.getString(resId)
}