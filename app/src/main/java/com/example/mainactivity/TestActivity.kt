package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.text.NumberFormat

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val Next = findViewById<Button>(R.id.Next)
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        val t0=findViewById<RadioGroup>(R.id.t0)
        content1.text = " 睡眠困難，譬如難以入睡、易醒或早醒"


        Next.setOnClickListener {
            val selectedId = t0.checkedRadioButtonId
            val tipPercentage = when (selectedId) {
                R.id.one ->0
                else -> "未選擇"

            }
            val test=findViewById<TextView>(R.id.textView12)
            var tip = tipPercentage
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            test.text = getString(R.string.tip_amount, formattedTip)
            val it = Intent(this, TestActivity2::class.java)
            startActivity(it)
        }
    }
}