package com.example.mainactivity


import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import java.util.*

class TimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        val START = findViewById<Button>(R.id.START)
        val RESET = findViewById<Button>(R.id.RESET)
        val timerText =findViewById<TextView>(R.id.timerText);
        var timer=findViewById<TextView>(R.id.timer)
        val chronometer=findViewById<Chronometer>(R.id.timerText)
        chronometer.setBase(SystemClock.elapsedRealtime());
        
        chronometer.setOnChronometerTickListener{

        }
        START.setOnClickListener {
            chronometer.start();
        }
        RESET.setOnClickListener {
            chronometer.stop();

        }

        val Back2 = findViewById<Button>(R.id.Back2)
        Back2.setOnClickListener {
            finish()

        }

    }










    }
