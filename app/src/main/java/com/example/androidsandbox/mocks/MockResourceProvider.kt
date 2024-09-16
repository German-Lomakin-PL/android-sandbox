package com.example.androidsandbox.mocks

import com.example.androidsandbox.modules.ResourceProvider

class MockResourceProvider: ResourceProvider {
    override fun getString(resId: Int): String = "Mocked String"
}