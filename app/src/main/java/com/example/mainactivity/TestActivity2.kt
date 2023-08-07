package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

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
        val t1=findViewById<RadioGroup>(R.id.t1)
        content1.text = " 感覺緊張不安"

        // 從 test1 接收分數
        val score1 = intent.getIntExtra("score1", 0)


        Next.setOnClickListener {v->
            // 取得所選擇的分數
            val score2 = when (t1.checkedRadioButtonId) {
                R.id.zero -> 0
                R.id.one -> 1
                R.id.two -> 2
                R.id.three -> 3
                R.id.four -> 4
                R.id.five -> 5
                else -> 0 // 如果未選擇，預設為0分
            }

            // 計算總分（score1+score2）
            val totalScore = score1 + score2

            // 傳遞分數到下一個頁面

            val intent = Intent(this, TestActivity3::class.java)
            intent.putExtra("totalScore", totalScore)
            startActivity(intent)
        }


    }
}


private operator fun Int.plus(b: Bundle) {

}
