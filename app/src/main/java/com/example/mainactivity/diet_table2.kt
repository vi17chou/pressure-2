package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class diet_table2: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diet_table2)//顯示diet_table2的畫面
        //設定隱藏標題
        getSupportActionBar()?.hide();
        //val diary = findViewById<Button>(R.id.button3)
        //跳頁
        val Next = findViewById<ImageButton>(R.id.Next)

        Next.setOnClickListener {
            val it = Intent(this, TestActivity4::class.java)
            startActivity(it)
        }
    }
}