package com.example.androidsandbox

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidsandbox.ui.theme.AndroidSandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSandboxTheme {
                Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
                    MessageCard(
                        msg = Message(
                            "Arthur",
                            "What's up dude? Should we go for a walk tonight?",
                            "15:32"
                        )
                    )
                }
            }
        }
    }
}

data class Message(val author: String, val body: String, val time: String)

@Composable
fun MessageCard(msg: Message) {
    Row(
         modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Haha",
            )
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Haha",
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row {
                Text(
                    text = msg.author,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = "'s message:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
            Text(text = msg.body, style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary))
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.time,
                style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary),
            )
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun GreetingPreview() {
    AndroidSandboxTheme {
        Surface {
            MessageCard(
                msg = Message(
                    "Arthur",
                    "What's up dude? Should we go for a walk tonight?",
                    "15:32"
                )
            )
        }
    }
}