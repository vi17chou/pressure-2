package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TestActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)
        val Next=findViewById<Button>(R.id.Next)
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        content1.text = "感覺憂鬱、心情低落"
        Next.setOnClickListener {
            val it = Intent(this, TestActivity5::class.java)
            startActivity(it)
        }
    }
}