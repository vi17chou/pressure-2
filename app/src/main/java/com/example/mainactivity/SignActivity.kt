package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val next=findViewById<Button>(R.id.sign_next)
        next.setOnClickListener {
            val it=Intent(this,Sign2Activity::class.java)
            startActivity(it)
        }
    }
}