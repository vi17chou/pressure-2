package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val diary=findViewById<Button>(R.id.diary)
        val record=findViewById<Button>(R.id.record)
        val method=findViewById<Button>(R.id.method)

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
    }
}