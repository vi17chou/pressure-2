package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TestActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
        val Next = findViewById<Button>(R.id.Next)

        val previous_question = findViewById<Button>(R.id.previous_question)

        previous_question.setOnClickListener {
            finish()
        }
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        content1.text = "覺得容易苦惱或動怒"
        val T03=findViewById<TextView>(R.id.T03)
        val age = intent.getIntExtra("two", 2)//第一題
        val age2 = intent.getIntExtra("one", 1)//第二題



        var sum=0
        sum=age+age2
        T03.text="上一個傳過來的值"+sum
        Next.setOnClickListener {
            val it = Intent(this, TestActivity4::class.java)
            startActivity(it)
        }
    }
}