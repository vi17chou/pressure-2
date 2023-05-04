package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PuzzleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back4 = findViewById<ImageButton>(R.id.back4)

        back4.setOnClickListener {
            finish()

        }

    }
}