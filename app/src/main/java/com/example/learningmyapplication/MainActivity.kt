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
    }
}