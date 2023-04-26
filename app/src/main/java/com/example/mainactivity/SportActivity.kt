package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)
        val run=findViewById<Button>(R.id.run)
        val yuga=findViewById<Button>(R.id.yuga)
        val hit=findViewById<Button>(R.id.hit)
        run.setOnClickListener {
            val it= Intent(this,TimerActivity::class.java)
            startActivity(it)
        }

        yuga.setOnClickListener {
            val it= Intent(this,TimerActivity::class.java)
            startActivity(it)
        }

        hit.setOnClickListener {
            val it= Intent(this,TimerActivity::class.java)
            startActivity(it)
        }

        val Back2 = findViewById<Button>(R.id.Back2)

        Back2.setOnClickListener {
            finish()

        }
    }
}