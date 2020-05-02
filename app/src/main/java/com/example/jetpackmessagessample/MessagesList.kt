package com.example.jetpackmessagessample

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.tooling.preview.Preview

@Composable
fun MessagesList(list: MutableList<Message>,
                 itemClick : (message : Message) -> Unit){
        AdapterList(data = list) {
            MessageView(message = it,itemClick = itemClick)
        }
}


@Preview
@Composable
fun messagesListPreview(){
    val list = generateMessageList()
    MessagesList(list = list,itemClick = {})
}