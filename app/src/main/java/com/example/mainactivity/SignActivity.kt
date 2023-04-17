package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignActivity : AppCompatActivity() {
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            if (requestCode==1 && resultCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.newtest).text=
                    "姓名:${it.getString("na")}\n"+
                            "出生年月:${it.getString("ag")}\n"+
                            "性別:${it.getString("sex")}\n"
            }
        }
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val next=findViewById<Button>(R.id.sign_next)
        val btn_submit=findViewById<Button>(R.id.btn_submit)
        next.setOnClickListener {
            /*val intent =  Intent(this,Sign2Activity::class.java)
            startActivityForResult(intent,1)*/
        }
        btn_submit.setOnClickListener {
            val it=Intent(this,MainActivity::class.java)
            startActivity(it)
        }
    }
}