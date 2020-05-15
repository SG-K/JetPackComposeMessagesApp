package com.example.jetpackmessagessample.conversation

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.RowScope.weight
import androidx.ui.layout.padding
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.jetpackmessagessample.*

@Composable
fun ConversationListScreenView(list: MutableList<ChatMessage>,
                               itemClick : (message : ChatMessage) -> Unit){
    Scaffold(
        topAppBar = {
            messagesListTopBar("Conversation")
        }
    ) {
        ConversationList(list = list,itemClick = itemClick)
    }
}

@Preview
@Composable
fun conversationsPreview(){
    val list = generateConversationList()
    ConversationListScreenView(list = list,
        itemClick = { message: ChatMessage -> conversationClick(chatMessage = message) })
}

fun generateConversationList(): MutableList<ChatMessage> {
    return (0..100).map {
        ChatMessage(
            senderImage = "",
            message = "Dear patron Plz ignore the earlier SMS on due date and amt for may, we will send out the corrected SMS in a while. Regret the inconvenience caused.  Team ACT"
        )
    }.toMutableList()
}

fun conversationClick(chatMessage: ChatMessage){

}