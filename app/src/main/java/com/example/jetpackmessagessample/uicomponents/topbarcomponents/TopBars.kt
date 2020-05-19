package com.example.jetpackmessagessample.uicomponents.topbarcomponents

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.RowScope.weight
import androidx.ui.layout.padding
import androidx.ui.material.TopAppBar
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.jetpackmessagessample.R
import com.example.jetpackmessagessample.models.Actions
import com.example.jetpackmessagessample.models.ComponentToRender

@Composable
fun MoviesTopBar(component : ComponentToRender){
    TopAppBar(
        title = {
            Text(
                text = component.title,
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
            if (component.actions.isNotEmpty()){
                showActions(component.actions)
            }
        },
        backgroundColor = Color.White
    )
}

@Composable
fun showActions(actionsToShow : ArrayList<Actions>) {
    actionsToShow.forEach {
        when(it.type){
            "search" -> Icon(asset = vectorResource(id = it.resource),modifier = Modifier.padding(start = 8.dp,end = 10.dp))
            "more" ->  Icon(asset = vectorResource(id = it.resource),modifier = Modifier.padding(start = 10.dp,end = 8.dp))
        }
    }
}
