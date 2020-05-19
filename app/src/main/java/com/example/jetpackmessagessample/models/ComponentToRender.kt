package com.example.jetpackmessagessample.models

data class ComponentToRender (
    val type : String,
    val title : String = "",
    val imageUrl : String? = null,
    val actions: ArrayList<Actions> = ArrayList(),
    val content : InnerComponentsToRender? = null
)

data class InnerComponentsToRender(
    val list : ArrayList<ComponentToRender>,
    val subTitle : String = "",
    val description : String = ""
)