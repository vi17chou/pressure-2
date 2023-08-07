package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView

class TestActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)
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
        val t2=findViewById<RadioGroup>(R.id.t2)
        content1.text = " 覺得容易苦惱或動怒"

        // 從 test2 接收分數（score1+score2）
        val totalScoreFrom2 = intent.getIntExtra("totalScore", 0)

        Next.setOnClickListener {v->
            // 取得所選擇的分數
            val score3 = when (t2.checkedRadioButtonId) {
                R.id.zero -> 0
                R.id.one -> 1
                R.id.two -> 2
                R.id.three -> 3
                R.id.four -> 4
                R.id.five -> 5
                else -> 0 // 如果未選擇，預設為0分
            }
            // 計算所有三項活動的總分
            val totalScore = totalScoreFrom2 + score3

            // 傳遞分數到下一個頁面 result
            val intent = Intent(this, TestActivity4::class.java)
            intent.putExtra("totalScore", totalScore)
            startActivity(intent)
        }
    }
}