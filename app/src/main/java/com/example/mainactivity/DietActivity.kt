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

        val tea=findViewById<ImageButton>(R.id.tea)
        tea.setOnClickListener {
            val it= Intent(this,Diet_food2Activity::class.java)
            startActivity(it)
        }

        val banana=findViewById<ImageButton>(R.id.banana)
        banana.setOnClickListener {
            val it= Intent(this,Diet_food3Activity::class.java)
            startActivity(it)
        }

        val oat=findViewById<ImageButton>(R.id.oat)
        oat.setOnClickListener {
            val it= Intent(this,Diet_food4Activity::class.java)
            startActivity(it)
        }

        val cheese=findViewById<ImageButton>(R.id.cheese)
        cheese.setOnClickListener {
            val it= Intent(this,Diet_food5Activity::class.java)
            startActivity(it)
        }

        val og=findViewById<ImageButton>(R.id.og)
        og.setOnClickListener {
            val it= Intent(this,Diet_food6Activity::class.java)
            startActivity(it)
        }

        val chocolate=findViewById<ImageButton>(R.id.chocolate)
        chocolate.setOnClickListener {
            val it= Intent(this,Diet_food7Activity::class.java)
            startActivity(it)
        }
    }
}