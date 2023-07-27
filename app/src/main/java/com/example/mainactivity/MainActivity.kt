package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val login=findViewById<ImageButton>(R.id.login)
        val sign=findViewById<ImageButton>(R.id.sign)
        val mng=findViewById<Button>(R.id.mng)

        login.setOnClickListener {
         //   val it=Intent(this,ExplainActivity::class.java)測驗題目先跳過不然每次都要點11題很浪費時間
            val it=Intent(this,TestActivity::class.java)
            startActivity(it)
        }

        sign.setOnClickListener {
            val it=Intent(this,SignActivity::class.java)
            startActivity(it)
        }
        mng.setOnClickListener {
            val it=Intent(this,Manage_Home::class.java)
            startActivity(it)
        }
    }
}