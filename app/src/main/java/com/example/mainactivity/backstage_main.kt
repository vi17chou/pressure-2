package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class backstage_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_main)
        val mange_user=findViewById<Button>(R.id.manage_user)
        val manage_test=findViewById<Button>(R.id.manage_test)
        val manage_info=findViewById<Button>(R.id.manage_info)

        mange_user.setOnClickListener {
            val it= Intent(this,backstage_USER::class.java)
            startActivity(it)
        }

        manage_test.setOnClickListener {
            val it= Intent(this,backstage_test::class.java)
            startActivity(it)
        }

        manage_info.setOnClickListener {
            val it= Intent(this,backstage_USER::class.java)
            startActivity(it)
        }
    }
}