package com.example.androidsandbox.main

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun MessageCardPreview() {
    AndroidSandboxTheme {
        Surface {
            MessageCard(
                msg = MockData.messages.first()
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun MessageListPreview() {
    AndroidSandboxTheme {
        Surface {
            MessageList(MockData.messages)
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun ActionbarPreview() {
    AndroidSandboxTheme {
        Surface {
            MessagesActionbar(MockData.username)
        }
    }
}