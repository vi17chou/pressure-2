package com.example.mainactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.TextView
import java.util.Timer
import java.util.TimerTask
class TimerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        val STOP = findViewById<Button>(R.id.STOP)
        val RESET = findViewById<Button>(R.id.RESET)
        val timerText =findViewById<TextView>(R.id.timerText);


     //   timer = new Timer();

    }


        /*val Back2 = findViewById<Button>(R.id.Back2)
        Back2.setOnClickListener {
            finish()

        }*/
    }
