package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val next=findViewById<Button>(R.id.sign_next)
        val dialogBuilder = AlertDialog.Builder(this@SignActivity)
        val submit=findViewById<Button>(R.id.sign_submit)
        next.setOnClickListener {
            val dialogItem = LayoutInflater.from(this).inflate(R.layout.activity_sign2, null)
            AlertDialog.Builder(this)
                .setView(R.layout.activity_sign2)
                .setPositiveButton("OK"){ dialog, which->

                }.show()
        }

        submit.setOnClickListener {
            finish()
        }
    }
}