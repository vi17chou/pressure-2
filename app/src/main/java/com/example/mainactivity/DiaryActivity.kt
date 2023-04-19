package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DiaryActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode==1 && resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.newtest).text=
                    "今日日期:${it.getString("now_date")}\n"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        val New=findViewById<Button>(R.id.New)
        val select=findViewById<Button>(R.id.select)
        val del=findViewById<Button>(R.id.del)

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
    }
}