package com.example.learningmyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
        val btnSendMsgToNextActivity = findViewById<Button>(R.id.btnSendMsgToNextActivity)
        val etUserMessage = findViewById<EditText>(R.id.etUserMessage)
        val btnShareToOtherApps = findViewById<Button>(R.id.btnShareToOtherApps)
        val btnRecyclerViewDemo = findViewById<Button>(R.id.btnRecyclerViewDemo)
        btnShowToast.setOnClickListener {
            Log.i("MainActivity","Button was clicked !")
            Toast.makeText(this,"Button was clicked !",Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNextActivity.setOnClickListener {
            val message : String = etUserMessage.text.toString()
//            Toast.makeText(this , message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("user_message" , message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener {
            val message : String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share To : "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this ,HobbiesActivity::class.java )
            startActivity(intent)
        }
    }
}