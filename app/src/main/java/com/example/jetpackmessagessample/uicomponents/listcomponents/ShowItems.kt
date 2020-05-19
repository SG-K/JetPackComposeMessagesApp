package com.example.jetpackmessagessample.uicomponents.listcomponents

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.tag
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.px
import androidx.ui.unit.sp
import com.example.jetpackmessagessample.models.ComponentToRender
import com.example.jetpackmessagessample.uicomponents.invokeComponentsGlobally
import com.example.jetpackmessagessample.uicomponents.screens.print
import com.example.jetpackmessagessample.utils.ComponentsTypes
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.coil.CoilImageWithCrossfade

@Composable
fun verticalListComponents(componentToRender: ComponentToRender){
    "Entered into vertical component".print()
    if (componentToRender.content?.list?.isNotEmpty() == true){

        ConstraintLayout(constraintSet = ConstraintSet {

            tag(ComponentsTypes.topBar).apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo parent.top
            }

            tag(ComponentsTypes.verticalScroller).apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo tag(ComponentsTypes.topBar).bottom
            }

        }) {

            headerView(componentToRender = componentToRender)
            VerticalScroller(modifier = Modifier.tag(ComponentsTypes.verticalScroller)) {
                componentToRender.content.list.forEach {
                    invokeComponentsGlobally(it)
                }
            }

        }

    }

}

@Composable
fun horizontalListComponents(componentToRender: ComponentToRender){
    "Entered into horizontal component".print()
    if (componentToRender.content?.list?.isNotEmpty() == true){

        ConstraintLayout(constraintSet = ConstraintSet {

            tag(ComponentsTypes.topBar).apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo parent.top
            }

            tag(ComponentsTypes.horizontalScroller).apply {
                right constrainTo parent.right
                left constrainTo parent.left
                top constrainTo tag(ComponentsTypes.topBar).bottom
            }

        }) {

            headerView(componentToRender = componentToRender)
            HorizontalScroller(modifier = Modifier.tag(ComponentsTypes.horizontalScroller)) {
                Row {
                    componentToRender.content.list.forEach {
                        invokeComponentsGlobally(it)
                    }
                }
            }

        }

    }
}

@Composable
fun headerView(componentToRender: ComponentToRender){
    Text(text = componentToRender.title,
        modifier =  Modifier.padding(bottom = 5.dp,end = 16.dp,top = 5.dp,start = 16.dp)
            .tag(ComponentsTypes.horizontalScroller)
            .fillMaxWidth(),
        style = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        ),
        maxLines = 1)
}

@Composable
fun coverItem(componentToRender: ComponentToRender){
    CoilImageWithCrossfade(
        data = componentToRender.imageUrl as Any,
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(200.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun bannerItem(componentToRender: ComponentToRender){
    CoilImageWithCrossfade(
        data = componentToRender.imageUrl as Any,
        modifier = Modifier.preferredSize(78.dp,127.dp)
            .padding(1.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun largebannerItem(componentToRender: ComponentToRender){
    CoilImageWithCrossfade(
        data = componentToRender.imageUrl as Any,
        modifier = Modifier.preferredSize(125.dp,175.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun showingCoilPreview(){
//    coverItem()
}
