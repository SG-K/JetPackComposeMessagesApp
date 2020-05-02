package com.example.jetpackmessagessample.conversation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import com.example.jetpackmessagessample.Message

class ConversationActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversationListScreenView(list = generateConversationList(),
                itemClick = {message: ChatMessage ->
                    messageClik(
                        message = message
                    )
                } )
        }
    }

    fun fabclicks(){
        Log.v("sample_ksdjds", "fabclicks ")
    }

    fun messageClik(message: ChatMessage){
        Log.v("sample_ksdjds", "messageClik - ${message.message} ")
    }

    fun generateConversationList(): MutableList<ChatMessage> {
        return (0..100).map {
            ChatMessage(
                senderImage = "",
                message = "Dear patron Plz ignore the earlier SMS on due date and amt for may, we will send out the corrected SMS in a while. Regret the inconvenience caused.  Team ACT"
            )
        }.toMutableList()
    }

}