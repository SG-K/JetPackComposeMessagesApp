package com.example.jetpackmessagessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.ui.core.setContent

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            val list = generateMessageList()
            MessagesListScreenView(
                title = "Messages",
                list = list,
                fabClick = {fabclicks()},
                itemClick = {message: Message -> messageClik(message = message) }
            )
        }

    }
}

fun fabclicks(){
    Log.v("sample_ksdjds", "fabclicks ")
}

fun lamdaSample(){
    Log.v("sample_ksdjds", "lamdaSample ")
}

fun messageClik(message: Message){
    Log.v("sample_ksdjds", "messageClik - ${message.sender} ")
//    startActivity(
//        Intent(
//            this@MainActivity,
//            UserListActivity::class.java
//        )
//    )

}


fun display(name : String){
    fun greeting(): String{
        return "Hello "
    }
    Log.v("sample_ksdjds", " - ${greeting() + name} ")
}

fun generateMessageList(): MutableList<Message> {
    return (0..100).map {
        Message(
            sender = "Test sender $it",
            time = "10:00 AM",
            message = "Message body text Message body text Message body text Message body text Message body text "
        )
    }.toMutableList()
}