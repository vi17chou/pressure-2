package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val Next = findViewById<Button>(R.id.Next)
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        content1.text = "  睡眠困難，譬如難以入睡、易醒或早醒"

        Next.setOnClickListener {
            val it = Intent(this, TestActivity2::class.java)
            startActivity(it)
        }
    }
}