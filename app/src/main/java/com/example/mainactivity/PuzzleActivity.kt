package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PuzzleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)

        val back4 = findViewById<Button>(R.id.back4)

        back4.setOnClickListener {
            finish()

        }

    }
}