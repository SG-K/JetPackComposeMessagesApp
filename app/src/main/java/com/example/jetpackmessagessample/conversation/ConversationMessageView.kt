package com.example.jetpackmessagessample.conversation

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.px
import androidx.ui.unit.sp
import com.example.jetpackmessagessample.Message
import com.example.jetpackmessagessample.R
import com.example.jetpackmessagessample.SenderIcon

@Composable
fun ConversationMessageiew(chatMessage: ChatMessage,
                           itemClick : (message : ChatMessage) -> Unit){

    Clickable(onClick = {
        itemClick(chatMessage)
    }) {
        Row(
            verticalGravity = Alignment.Bottom,
            modifier = Modifier. drawBackground(color = Color.White).
                padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            SenderIcon()
            Row(modifier = Modifier.padding(start = 16.dp)
                .drawBackground(color = Color(0xFFf2f3f5),
                    shape = RoundedCornerShape(10.px))) {
                conversationMessage(chatMessage.message)
            }
        }
    }
}


//@Composable
//fun SenderIcon() {
//    Box(
//        backgroundColor = Color.DarkGray,
//        modifier = Modifier.clip(CircleShape)
//            .preferredSize(30.dp)
//    ) {
//        Icon(
//            asset = vectorResource(id = R.drawable.ic_person),
//            tint = Color.LightGray,
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}

@Composable
fun conversationMessage(message : String){
    Text(
        text = message,
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 15.sp
        ),
        modifier = Modifier.padding(start = 10.dp,top = 10.dp, end = 10.dp, bottom = 10.dp)
    )
}

@Preview
@Composable
fun conversationPreview(){
    val chatMessage = ChatMessage(
        senderImage = "",
        message = "hsbshdbcs sbcd ksdjcnsdkc dcksdnckd dcksdjcnksjdnc hsbshdbcs sd ksdjcnsdkc dcksdnckd dcksdjcnksjdnc c dchbdhcb dcbkdh dkcbksdck dcbdksckds ckdjcnksdnc "
    )
    ConversationMessageiew(chatMessage,{})
}