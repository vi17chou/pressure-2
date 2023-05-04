package com.example.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class EmotionActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back = findViewById<ImageButton>(R.id.btn_method)
        back.setOnClickListener {
            finish()
        }
    }
}