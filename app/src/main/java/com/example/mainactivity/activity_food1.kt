package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class activity_food1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food1)//跳新的頁面
        val back5 = findViewById<Button>(R.id.button)

        back5.setOnClickListener {
            finish()//hello123
//有錯嗎
        }
    }
}