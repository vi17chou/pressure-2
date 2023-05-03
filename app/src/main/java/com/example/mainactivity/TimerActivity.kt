package com.example.mainactivity


import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        val START = findViewById<ImageButton>(R.id.START)
        val STOP = findViewById<ImageButton>(R.id.STOP)
        val timerText =findViewById<TextView>(R.id.timerText);
        var timer=findViewById<TextView>(R.id.T02)
        val chronometer=findViewById<Chronometer>(R.id.timerText)
        chronometer.setBase(SystemClock.elapsedRealtime());
        
        chronometer.setOnChronometerTickListener{

        }
        START.setOnClickListener {
            chronometer.start();
        }
        STOP.setOnClickListener {
            chronometer.stop();

        }

        val Back2 = findViewById<ImageButton>(R.id.Back2)
        Back2.setOnClickListener {
            finish()

        }

    }










    }
