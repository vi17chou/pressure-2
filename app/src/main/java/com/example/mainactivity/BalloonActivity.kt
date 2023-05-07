package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class BalloonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balloon)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back5 = findViewById<ImageButton>(R.id.back5)

        back5.setOnClickListener {
            finish()//hello123
//有錯嗎
        }

    }
}