package com.example.mainactivity

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val Next = findViewById<Button>(R.id.Next)

        val previous_question = findViewById<Button>(R.id.previous_question)

        previous_question.setOnClickListener {
            finish()
        }
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        content1.text = "感覺緊張不安";

        
        Next.setOnClickListener {
            val it = Intent(this,TestActivity3::class.java)
            startActivity(it)
        }
    }
}