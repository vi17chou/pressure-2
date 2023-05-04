package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class TestActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val Next=findViewById<ImageButton>(R.id.Next)

        val previous_question = findViewById<ImageButton>(R.id.previous_question)

        previous_question.setOnClickListener {
            finish()
        }
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