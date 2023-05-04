package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val login=findViewById<ImageButton>(R.id.login)
        val sign=findViewById<ImageButton>(R.id.sign)
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