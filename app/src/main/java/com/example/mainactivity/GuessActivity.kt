package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        val guess_submit=findViewById<Button>(R.id.guess_submit)
        val back6 = findViewById<Button>(R.id.back6)
        val number=findViewById<TextView>(R.id.number)

        back6.setOnClickListener {
            finish()

        }
    }
}