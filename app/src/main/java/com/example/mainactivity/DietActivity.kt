package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class DietActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet)//現在的layout是顯示原始的畫面
        //設定隱藏標題
        getSupportActionBar()?.hide()
        val img_diet=findViewById<ImageButton>(R.id.img_diet)
        img_diet.setOnClickListener {
            val it= Intent(this,Diet_food1Activity::class.java)
            startActivity(it)
        }
        /*val back = findViewById<ImageButton>(R.id.im_btn1)
        back.setOnClickListener {
            finish()
        }*/
    }
}