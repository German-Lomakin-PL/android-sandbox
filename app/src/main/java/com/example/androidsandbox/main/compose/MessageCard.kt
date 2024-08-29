package com.example.androidsandbox.main.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidsandbox.R
import com.example.androidsandbox.main.model.Message

@Composable
fun MessageCard(msg: Message) {
    var isPressed by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .animateContentSize()
            .clickable { isPressed = !isPressed }
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(
                    if (isPressed) 5.dp else 1.dp,
                    MaterialTheme.colorScheme.primary,
                    CircleShape
                )
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
                    ),
                    maxLines = 1
                )
                Text(
                    text = "'s message:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    maxLines = if (isPressed) 1 else 1
                )
            }
            Text(
                text = msg.body,
                style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary),
                maxLines = if (isPressed) Int.MAX_VALUE else 1)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = msg.time,
                style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary),
            )
        }
    }
}