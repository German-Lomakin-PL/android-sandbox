package com.example.androidsandbox.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun GreetingPreview() {
    AndroidSandboxTheme {
        Surface {
            Column {
                MessageCard(
                    msg = Message(
                        "Arthur",
                        "What's up dude? Should we go for a walk tonight?",
                        "15:32"
                    )
                )
                MessageCard(
                    msg = Message(
                        "German",
                        "Hey! Let's go to the beach",
                        "15:34"
                    )
                )
                MessageCard(
                    msg = Message(
                        "Arthur",
                        "For sure! Meet you there",
                        "16:02"
                    )
                )
            }
        }
    }
}