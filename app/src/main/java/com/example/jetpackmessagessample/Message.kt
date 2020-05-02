package com.example.jetpackmessagessample

import android.media.Image

data class Message(val time: String,
                   val message : String,
                   val sender : String,
                   val senderImage : String? = null)