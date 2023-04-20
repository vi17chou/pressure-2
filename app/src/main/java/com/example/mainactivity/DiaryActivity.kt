package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DiaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        val New=findViewById<Button>(R.id.New)
        val select=findViewById<Button>(R.id.select)
        val del=findViewById<Button>(R.id.del)
        val back_home=findViewById<Button>(R.id.back_home)

        New.setOnClickListener {
            val intent =  Intent(this,NewActivity::class.java)
            startActivityForResult(intent,1)
        }

        select.setOnClickListener {
            val it= Intent(this,SelectActivity::class.java)
            startActivity(it)
        }

        del.setOnClickListener {
            val it= Intent(this,DelActivity::class.java)
            startActivity(it)
        }

        back_home.setOnClickListener {
            finish()
        }
    }
}