package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val diary=findViewById<ImageButton>(R.id.diary)
        val record=findViewById<ImageButton>(R.id.record)
        val method=findViewById<ImageButton>(R.id.method)
        val signout=findViewById<Button>(R.id.signout)

        diary.setOnClickListener {
            val it= Intent(this,DiaryActivity::class.java)
            startActivity(it)
        }

        record.setOnClickListener {
            val it= Intent(this,RecordActivity::class.java)
            startActivity(it)
        }

        method.setOnClickListener {
            val it= Intent(this,MethodActivity::class.java)
            startActivity(it)
        }

        signout.setOnClickListener {
            val it= Intent(this,MainActivity::class.java)
            startActivity(it)
        }
    }
}