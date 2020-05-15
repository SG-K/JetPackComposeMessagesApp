package com.example.jetpackmessagessample

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

@Composable
fun MessagesListScreenView(title : String, list : MutableList<Message>,
                           fabClick :()-> Unit,
                           itemClick : (message : Message) -> Unit){
        Scaffold(
            topAppBar = {
                messagesListTopBar(title)
            },
            floatingActionButton = {
                floatingButton(fabClick)
            }
        ) {
            MessagesList(list = list,itemClick = itemClick)
        }
}

@Composable
fun floatingButton(fabClick :()-> Unit){
    FloatingActionButton(onClick = {
        fabClick()
    }) {
        Icon(asset = vectorResource(id = R.drawable.ic_add))
    }
}

@Composable
fun messagesListTopBar(title : String){
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        },
        actions = {
            Icon(asset = vectorResource(id = R.drawable.ic_search),modifier = Modifier.padding(start = 8.dp,end = 10.dp))
            Icon(asset = vectorResource(id = R.drawable.ic_options_menu),modifier = Modifier.padding(start = 10.dp,end = 8.dp))
        },
        backgroundColor = Color.White
    )
}

@Preview
@Composable
fun messagesListScreenPreview(){
    val list = generateMessageList()
    MessagesListScreenView(title = "Messages",list = list,fabClick = {fabclicks()},
        itemClick = { message: Message -> messageClik(message = message) })
}

