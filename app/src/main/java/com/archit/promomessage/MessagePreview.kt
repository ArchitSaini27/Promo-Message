package com.archit.promomessage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_message_preview.button_send_message
import kotlinx.android.synthetic.main.activity_message_preview.text_view_message_preview

class MessagePreview : AppCompatActivity() {

    lateinit var message:Message
    lateinit var displayMessage:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_preview)
        displayMessage()
        sendMessage()
    }

    private fun displayMessage() {
        //        val contactName :String?=intent.getStringExtra("Contact Name")
        //        val contactNumber:String?=intent.getStringExtra("Contact Number")
        //        val displayName:String?=intent.getStringExtra("Display Name")
        //        val includeJunior:Boolean?=intent.getBooleanExtra("Include Junior",false)
        //        val jobTitle:String?=intent.getStringExtra("Job Title")
        //        val immediateJoiner:Boolean?=intent.getBooleanExtra("Immediate Joiner",false)
        //        val availableFromDate:String?=intent.getStringExtra("Available From Date")

        message= intent.getSerializableExtra("Message") as Message
        displayMessage = """
                Hi ${message.contactName}
                
                My name is ${message.displayName} and I am ${message.getFullJobTitle()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailableDate()}
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
            """.trimIndent()
        text_view_message_preview.text = displayMessage
    }
    private fun sendMessage(){
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:${message.contactNumber}")  // Only SMS apps respond to this.
                putExtra("sms_body", displayMessage)
            }
            startActivity(intent)
        }


    }



}