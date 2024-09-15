package com.example.androidsandbox.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidsandbox.main.compose.MessagesScreen
import com.example.androidsandbox.navigation.Routes
import com.example.androidsandbox.screens.chats.compose.ChatsScreen
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Application()
        }
    }
}

@Composable
fun Application(
    navController: NavHostController = rememberNavController()
) {
    AndroidSandboxTheme {
        Surface(contentColor = MaterialTheme.colorScheme.background) {
            Scaffold(
                contentColor = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding(),
            ) { contentPadding ->
                Column(Modifier.padding(contentPadding)) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.TAB_1,
                        modifier = Modifier.weight(1.0f, true)
                    ) {
                        composable(Routes.TAB_1) { AppNavigationHost() }
                        composable(Routes.TAB_2) { MessagesScreen() }
                    }
                    BottomNav(
                        onTab1 = {navController.navigate(Routes.TAB_1)},
                        onTab2 = {navController.navigate(Routes.TAB_2)},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.MESSAGES_LIST,
        modifier = modifier
    ) {
        composable(Routes.CHATS_LIST) { ChatsScreen() }
        composable(Routes.MESSAGES_LIST) { MessagesScreen() }
    }
}

@Composable
fun BottomNav(modifier: Modifier = Modifier, onTab1: () -> Unit, onTab2: () -> Unit) {
    Row(modifier.background(MaterialTheme.colorScheme.surfaceBright)) {
        Button(onClick = onTab1,
            Modifier
                .padding(10.dp)
                .weight(1.0f)) {
            Text(text = "TAB 1")
        }
        Button(onClick = onTab2,
            Modifier
                .padding(10.dp)
                .weight(1.0f)) {
            Text(text = "TAB 2")
        }
    }
}