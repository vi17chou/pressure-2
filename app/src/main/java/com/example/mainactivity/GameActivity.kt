package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val balloon=findViewById<Button>(R.id.balloon)
        val puzzle=findViewById<Button>(R.id.puzzle)
        val guess=findViewById<Button>(R.id.guess)

        balloon.setOnClickListener {
            val it= Intent(this,BalloonActivity::class.java)
            startActivity(it)
        }

        puzzle.setOnClickListener {
            val it= Intent(this,PuzzleActivity::class.java)
            startActivity(it)
        }

        guess.setOnClickListener {
            val it= Intent(this,GuessActivity::class.java)
            startActivity(it)
        }
        val button4 = findViewById<Button>(R.id.button4)

        button4.setOnClickListener {
            finish()
        }
    }
}