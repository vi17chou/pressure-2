package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class diet_table : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diet_table2)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        //val diary = findViewById<ImageButton>(R.id.img_btn1)
        val record = findViewById<ImageButton>(R.id.record)
        val method = findViewById<ImageButton>(R.id.method)

        /*diary.setOnClickListener {
            val it = Intent(this, activity_food1::class.java)
            startActivity(it)
        }*/
    }
}