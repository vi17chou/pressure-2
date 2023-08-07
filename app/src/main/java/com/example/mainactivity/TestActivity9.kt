package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView

class TestActivity9 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test9)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val Next = findViewById<ImageButton>(R.id.Next)

        //上一題
        val previous_question = findViewById<ImageButton>(R.id.previous_question)
        previous_question.setOnClickListener {
            finish()
        }
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        val t8 = findViewById<RadioGroup>(R.id.t8)
        content1.text = "我對任何事都提不起勁"

        // 從 test8 接收分數（score1+score2+score3+score4+score5+score6+score7+score8）
        val totalScoreFrom8 = intent.getIntExtra("totalScore", 0)


        Next.setOnClickListener { v ->
            // 取得所選擇的分數
            val score9 = when (t8.checkedRadioButtonId) {
                R.id.zero -> 0
                R.id.one -> 1
                R.id.two -> 2
                R.id.three -> 3
                R.id.four -> 4
                R.id.five -> 5
                else -> 0 // 如果未選擇，預設為0分
            }

            // 計算所有9項活動的總分
            val totalScore = totalScoreFrom8 + score9

            // 傳遞分數到下一個頁面 result
            val intent = Intent(this, TestActivity10::class.java)
            intent.putExtra("totalScore", totalScore)
            startActivity(intent)
        }

    }
    }
