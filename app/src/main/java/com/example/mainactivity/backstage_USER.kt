package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class backstage_USER : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_user)
        val backhome = findViewById<Button>(R.id.backhome)
        backhome.setOnClickListener {
            val it= Intent(this,backstage_main::class.java)
            startActivity(it)
        }
    }


}