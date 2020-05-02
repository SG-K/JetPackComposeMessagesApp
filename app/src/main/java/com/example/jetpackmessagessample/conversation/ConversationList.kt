package com.example.jetpackmessagessample.conversation

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import com.example.jetpackmessagessample.Message
import com.example.jetpackmessagessample.MessageView

@Composable
fun ConversationList(list: MutableList<ChatMessage>,
                 itemClick : (message : ChatMessage) -> Unit){
    AdapterList(data = list) {
        ConversationMessageiew(chatMessage = it,itemClick = itemClick)
    }
}