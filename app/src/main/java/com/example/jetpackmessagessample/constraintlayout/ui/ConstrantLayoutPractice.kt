package com.example.jetpackmessagessample.constraintlayout.ui

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.Text
import androidx.ui.foundation.drawBackground
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Scaffold
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.example.jetpackmessagessample.MessagesList
import com.example.jetpackmessagessample.floatingButton
import com.example.jetpackmessagessample.messagesListTopBar
import com.example.jetpackmessagessample.uicomponents.invokeComponentsGlobally
import com.example.jetpackmessagessample.uicomponents.listcomponents.headerView
import com.example.jetpackmessagessample.utils.ComponentsTypes

@Preview
@Composable
fun samplePreview(){
    usingChains()
}


@Composable
fun usingChains(){
    Scaffold(
    ) {
        ConstraintLayout(constraintSet = ConstraintSet {

            val barrier = createRightBarrier(tag("TextViewA"))
            tag("TextViewB").right constrainTo barrier
            tag("TextViewC").left constrainTo barrier

            tag("TextViewB").apply {
                top constrainTo tag("TextViewA").bottom
            }
            tag("TextViewC").apply {
                top constrainTo tag("TextViewB").bottom
            }

        }, modifier = Modifier.fillMaxSize()) {

            Text(text = "AAAAAA", modifier = Modifier.tag("TextViewA")
                .padding(10.dp),
                style = TextStyle(fontSize = 20.sp))

            Text(text = "BBB", modifier = Modifier.tag("TextViewB")
                .padding(10.dp)
                , style = TextStyle(fontSize = 20.sp))

            Text(text = "CC", modifier = Modifier.tag("TextViewC")
                .padding(10.dp)
                , style = TextStyle(fontSize = 20.sp))

        }
    }
}

@Composable
fun usingGuidelines(){
    Scaffold(
    ) {
        ConstraintLayout(constraintSet = ConstraintSet {
            val half = createGuidelineFromTop(0.5f)
            tag("TextViewA").apply {
                top constrainTo half
                left constrainTo parent.left
                right constrainTo parent.right
            }
            tag("TextViewB").apply {
                bottom constrainTo half
                left constrainTo parent.left
                right constrainTo parent.right
            }
        }, modifier = Modifier.fillMaxSize()) {
            Text(text = "A", modifier = Modifier.tag("TextViewA")
                .padding(10.dp),
                style = TextStyle(fontSize = 20.sp))

            Text(text = "B", modifier = Modifier.tag("TextViewB")
                .padding(10.dp)
                , style = TextStyle(fontSize = 20.sp))


        }
    }
}

@Composable
fun basicusage(){

    Scaffold(
    ) {
        ConstraintLayout(constraintSet = ConstraintSet {

            tag("TextViewA").apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo parent.top
                bottom constrainTo parent.bottom
            }

            tag("TextViewB").apply {
                right constrainTo tag("TextViewA").left
                top constrainTo tag("TextViewA").top
            }

            tag("TextViewC").apply {
                left constrainTo tag("TextViewA").right
                top constrainTo tag("TextViewA").top
            }

            tag("TextViewD").apply {
                right constrainTo parent.right
                left constrainTo parent.left
                bottom constrainTo tag("TextViewA").top
            }

            tag("TextViewE").apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo tag("TextViewA").bottom
            }

        },modifier = Modifier.fillMaxSize()) {

            Text(text = "A", modifier = Modifier.tag("TextViewA")
                .padding(10.dp),
                style = TextStyle(fontSize = 20.sp))
            Text(text = "B", modifier = Modifier.tag("TextViewB")
                .padding(10.dp)
                , style = TextStyle(fontSize = 20.sp))
            Text(text = "C", modifier = Modifier.tag("TextViewC")
                .padding(10.dp)
                , style = TextStyle(fontSize = 20.sp))
            Text(text = "D", modifier = Modifier.tag("TextViewD")
                , style = TextStyle(fontSize = 20.sp))
            Text(text = "E", modifier = Modifier.tag("TextViewE")
                , style = TextStyle(fontSize = 20.sp))

        }
    }


}