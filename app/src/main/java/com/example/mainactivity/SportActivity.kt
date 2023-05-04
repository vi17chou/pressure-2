package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class SportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sport)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val run=findViewById<ImageButton>(R.id.run)
        val yuga=findViewById<ImageButton>(R.id.yuga)
        val hit=findViewById<ImageButton>(R.id.hit)
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

        val Back2 = findViewById<ImageButton>(R.id.Back2)

        Back2.setOnClickListener {
            finish()

        }
    }
}