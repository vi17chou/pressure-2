package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TestActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
        val Next = findViewById<Button>(R.id.Next)
        Next.setOnClickListener {
            val it = Intent(this, TestActivity4::class.java)
            startActivity(it)
        }
    }
}