package com.example.androidsandbox.mocks

import com.example.androidsandbox.main.model.Message
import com.example.androidsandbox.screens.chats.model.Chat

object MockData {
    const val username = "Arthur"
    val messages = listOf(
        Message(
            "Arthur",
            "What's up dude? Should we go for a walk tonight? I plan to walk around city for many hours, riding bike or walk. Maybe we can buy a beer together? What do you think?",
            "mmm",
            "15:32"
        ),
        Message(
            "German",
            "Hey! Let's go to the beach",
            "mmm",
            "15:34"
        ),
        Message(
            "Arthur",
            "For sure! Meet you there",
            "mmm",
            "16:02"
        )
    )
}

object ChatsMockData {

    val chats = listOf(
        Chat("My private Group", "When we have next meeting?", "17:33"),
        Chat("Guitar lessons", "Did you practice today?", "03:16"),
        Chat("Bike Rides", "Lets go outside!", "13:20"),
        Chat("Polish Classes", "Homework - 134 ex. 3b/3c", "12:16"),
    )

}