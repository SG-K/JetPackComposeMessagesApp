package com.example.jetpackmessagessample

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun MessageView(message: Message,
                itemClick : (message : Message) -> Unit){
    Clickable(onClick = {
        itemClick(message)
    }) {
        Row( modifier = Modifier.padding(16.dp)) {
            SenderIcon()
            Column(modifier = Modifier.padding(start = 8.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)) {
                Row(verticalGravity = Alignment.CenterVertically) {
                    Sender(message.sender, modifier = Modifier.weight(1f))
                    MessageTime(time = message.time)
                }
                ShortMessage(shortMessage = message.message)
            }
        }
    }
}


@Composable
fun MessageTime(time : String){
    Text(
        text = time,
        style = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp
        ),
        maxLines = 1
    )
}

@Composable
fun ShortMessage(shortMessage : String, modifier: Modifier = Modifier){
    Text(
        text = shortMessage,
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 14.sp
        ),
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun Sender(sender: String, modifier: Modifier = Modifier) {
    Text(
        text = sender,
        style = TextStyle(
            color = Color.Black,
            fontSize = 18.sp
        ),
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun SenderIcon() {
    Box(
        backgroundColor = Color.DarkGray,
        modifier = Modifier.clip(CircleShape)
            .preferredSize(30.dp)
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_person),
            tint = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun MessageViewPreview() {
    val message = Message(
        sender = "Test sender",
        time = "10:00 AM",
        message = "Hello there, how are you?"
    )
    MessageView(message = message,itemClick = {})
}