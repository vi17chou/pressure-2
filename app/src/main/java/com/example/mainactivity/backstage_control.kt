package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class backstage_control : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_control)
        val backhome=findViewById<Button>(R.id.backhome)

        backhome.setOnClickListener {
            val it= Intent(this,backstage_main::class.java)
            startActivity(it)
        }
    }
}