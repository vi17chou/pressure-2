package com.example.mainactivity

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import java.text.NumberFormat

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val Next = findViewById<Button>(R.id.Next)

        val previous_question = findViewById<Button>(R.id.previous_question)

        previous_question.setOnClickListener {
            finish()
        }
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        content1.text = "感覺緊張不安";
        val t1=findViewById<RadioGroup>(R.id.t1)
        
        Next.setOnClickListener {
            val selectedId = t1.checkedRadioButtonId

            val tipPercentage = when (selectedId) {
                R.id.one -> 0
                else -> "未選擇"

            }
            val test=findViewById<TextView>(R.id.textView10)
            var tip2 = tipPercentage
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip2)
            test.text = getString(R.string.tip_amount, formattedTip)
            val it = Intent(this,TestActivity3::class.java)
            startActivity(it)
        }
    }
}