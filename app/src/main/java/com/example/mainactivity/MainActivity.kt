package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login=findViewById<Button>(R.id.login)
        val sign=findViewById<Button>(R.id.sign)
        login.setOnClickListener {
            val it=Intent(this,ExplainActivity::class.java)
            startActivity(it)
        }

        sign.setOnClickListener {
            val it=Intent(this,SignActivity::class.java)
            startActivity(it)
        }
    }
}