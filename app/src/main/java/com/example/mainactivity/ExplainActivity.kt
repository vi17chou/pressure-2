package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ExplainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explain)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val start=findViewById<ImageButton>(R.id.start)
        start.setOnClickListener {
            val it= Intent(this,TestActivity::class.java)
            startActivity(it)
        }
    }
}