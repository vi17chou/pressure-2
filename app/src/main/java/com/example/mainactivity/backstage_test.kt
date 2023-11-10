package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class backstage_test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_test)
        val backhome = findViewById<Button>(R.id.backhome)
        val test_result = findViewById<Button>(R.id.test_result)

        test_result.setOnClickListener {
            val it= Intent(this,backstage_DietFood::class.java)
            startActivity(it)
        }

        backhome.setOnClickListener {
            val it= Intent(this,backstage_main::class.java)
            startActivity(it)
        }
    }
}