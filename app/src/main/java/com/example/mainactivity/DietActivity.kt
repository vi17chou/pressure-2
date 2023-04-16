package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DietActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diet_table)
        val back = findViewById<Button>(R.id.btn_diet)
        back.setOnClickListener {
            finish()
        }
    }
}