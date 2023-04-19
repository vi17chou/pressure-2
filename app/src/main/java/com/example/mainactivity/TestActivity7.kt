package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TestActivity7 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test7)
        val Next = findViewById<Button>(R.id.Next)
        Next.setOnClickListener {
            val it = Intent(this, TestActivity8::class.java)
            startActivity(it)
        }
    }
}