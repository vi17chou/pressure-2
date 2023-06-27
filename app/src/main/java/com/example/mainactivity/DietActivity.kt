package com.example.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class DietActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)//現在的layout是顯示test的畫面
        //設定隱藏標題
        getSupportActionBar()?.hide();
        /*val back = findViewById<ImageButton>(R.id.im_btn1)
        back.setOnClickListener {
            finish()
        }*/
    }
}