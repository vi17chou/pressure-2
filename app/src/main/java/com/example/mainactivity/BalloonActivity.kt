package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BalloonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balloon)

        val back5 = findViewById<Button>(R.id.back5)

        back5.setOnClickListener {
            finish()

        }

    }
}