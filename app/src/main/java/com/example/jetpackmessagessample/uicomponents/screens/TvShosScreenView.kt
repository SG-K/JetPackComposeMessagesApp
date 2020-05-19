package com.example.jetpackmessagessample.uicomponents.screens

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.Scaffold
import com.example.jetpackmessagessample.Message
import com.example.jetpackmessagessample.MessagesList
import com.example.jetpackmessagessample.floatingButton
import com.example.jetpackmessagessample.messagesListTopBar
import com.example.jetpackmessagessample.models.Actions
import com.example.jetpackmessagessample.models.ComponentToRender
import com.example.jetpackmessagessample.uicomponents.invokeComponentsGlobally
import com.example.jetpackmessagessample.uicomponents.topbarcomponents.MoviesTopBar
import com.example.jetpackmessagessample.utils.ComponentsTypes

@Composable
fun MessagesListScreenView(list : MutableList<ComponentToRender>){
    Scaffold(topAppBar = {
            list.single { it.type.equals(ComponentsTypes.topBar,true) }.let {
                MoviesTopBar(it)
            }
        }) {
        VerticalScroller(modifier = Modifier.tag(ComponentsTypes.verticalScroller)) {
            Column {
                list.filter { !it.type.equals(ComponentsTypes.topBar,true) }.forEach {
                    invokeComponentsGlobally(component = it)
                }
            }
        }

    }
}

