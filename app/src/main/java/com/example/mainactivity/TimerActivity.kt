package com.example.mainactivity


import android.os.Bundle
import android.widget.Button
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
        /*START.setOnClickListener {
            //启动计时器

        }*/

     //   timer = new Timer();

    }


        /*val Back2 = findViewById<Button>(R.id.Back2)
        Back2.setOnClickListener {
            finish()

        }*/
    }
