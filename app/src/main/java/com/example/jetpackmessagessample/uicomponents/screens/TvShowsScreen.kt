package com.example.jetpackmessagessample.uicomponents.screens

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import com.example.jetpackmessagessample.models.ComponentToRender
import com.example.jetpackmessagessample.models.InnerComponentsToRender
import com.example.jetpackmessagessample.utils.ComponentsTypes

fun Any.print(){
    Log.v("sdhvbsvb", "$this")
}

class TvShowsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = getTvShowsList()
            MessagesListScreenView(list = list)
        }
    }

    private fun getTvShowsList(): ArrayList<ComponentToRender> {
        val tvShowSLsts : ArrayList<ComponentToRender> = ArrayList()
        tvShowSLsts.add(getHeaderObject())

        tvShowSLsts.add(getVerticalBAnnerlLis("Header 1"))
//        tvShowSLsts.add(getVerticalCoverLis("Header 2"))
        tvShowSLsts.add(getVerticalBAnnerlLis("Header 3"))

//        for (i in 1 .. 3){
//            when(i){
//                1 -> {
//                    tvShowSLsts.add(getVerticalBAnnerlLis("Header $i"))
//                }
//                2 -> {
//                    tvShowSLsts.add(getVerticalCoverLis("Header $i"))
//                }
//                3 -> {
//                    tvShowSLsts.add(getVerticalBAnnerlLis("Header $i"))
//                }
//            }
//        }


        tvShowSLsts.print()
        return tvShowSLsts

    }

    fun getVerticalCoverLis(title : String) : ComponentToRender{
        val list : ArrayList<ComponentToRender> = ArrayList()
        for (i in 1 .. 5){
            list.add(getCoverObject())
        }
        val componentToRender : ComponentToRender =
            ComponentToRender(title = title,type = ComponentsTypes.horizontalScroller,
                content = InnerComponentsToRender(list))

        return componentToRender
    }

    fun getVerticalBAnnerlLis(title : String) : ComponentToRender{

        val list : ArrayList<ComponentToRender> = ArrayList()
        for (i in 1 .. 5){
            list.add(getBannerObject())
        }

        val componentToRender : ComponentToRender =
            ComponentToRender(title = title,type = ComponentsTypes.horizontalScroller,
                content = InnerComponentsToRender(list))

        return componentToRender
    }

    fun getCoverObject() = ComponentToRender(type = ComponentsTypes.coverView,
        imageUrl = ComponentsTypes.cover)

    fun getBannerObject() = ComponentToRender(type = ComponentsTypes.bannerView,
        imageUrl = ComponentsTypes.banner)

    fun getLargeBannerObject() = ComponentToRender(type = ComponentsTypes.largeBannerView,
        imageUrl = ComponentsTypes.banner)

    fun getHeaderObject() = ComponentToRender(title = "TvShows", type = ComponentsTypes.topBar)

}