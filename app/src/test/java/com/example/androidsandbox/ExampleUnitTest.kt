package com.example.androidsandbox

import com.example.androidsandbox.main.MainViewModel
import com.example.androidsandbox.mocks.MockResourceProvider
import com.example.androidsandbox.screens.chats.ChatsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class MainDispatcherRule @OptIn(ExperimentalCoroutinesApi::class) constructor(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

class ExampleUnitTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun viewModelSimpleTest() = runTest {
        val viewModel = MainViewModel(MockResourceProvider())
        viewModel.refresh()

        val states = viewModel.uiState.take(2).toList()

        assertEquals(states[0].isRefreshing, true)
        assertEquals(states[1].isRefreshing, false)
        assertEquals(states[1].messages.isNotEmpty(), true)
    }

}