package com.example.jetpackmessagessample.uicomponents

import androidx.compose.Composable
import com.example.jetpackmessagessample.models.ComponentToRender
import com.example.jetpackmessagessample.uicomponents.listcomponents.verticalListComponents
import com.example.jetpackmessagessample.uicomponents.listcomponents.horizontalListComponents
import com.example.jetpackmessagessample.uicomponents.listcomponents.headerView
import com.example.jetpackmessagessample.uicomponents.listcomponents.largebannerItem
import com.example.jetpackmessagessample.uicomponents.listcomponents.bannerItem
import com.example.jetpackmessagessample.uicomponents.listcomponents.coverItem
import com.example.jetpackmessagessample.uicomponents.topbarcomponents.MoviesTopBar
import com.example.jetpackmessagessample.utils.ComponentsTypes

@Composable
fun invokeComponentsGlobally(component : ComponentToRender){
    when(component.type){

        ComponentsTypes.topBar -> MoviesTopBar(component)

        ComponentsTypes.verticalScroller -> verticalListComponents(component)

        ComponentsTypes.horizontalScroller -> horizontalListComponents(component)

        ComponentsTypes.headerView -> headerView(component)

        ComponentsTypes.largeBannerView -> largebannerItem(component)

        ComponentsTypes.bannerView -> bannerItem(component)

        ComponentsTypes.coverView -> coverItem(component)

    }
}