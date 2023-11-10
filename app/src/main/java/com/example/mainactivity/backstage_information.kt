package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class backstage_information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_information)
        val diary_select=findViewById<Button>(R.id.diary_select)
        val diet_select=findViewById<Button>(R.id.diet_select)
        val emotion_select=findViewById<Button>(R.id.emotion_select)

        diary_select.setOnClickListener {
            val it= Intent(this,backstage_diary::class.java)
            startActivity(it)
        }

        diet_select.setOnClickListener {
            val it= Intent(this,backstage_DietFood::class.java)
            startActivity(it)
        }

        emotion_select.setOnClickListener {
            val it= Intent(this,backstage_emotion::class.java)
            startActivity(it)
        }
    }
}