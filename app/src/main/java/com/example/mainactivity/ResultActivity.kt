package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val home_page=findViewById<ImageButton>(R.id.home_page)
        val textView6 = findViewById<TextView>(R.id.tips)
        val textViewString = textView6.text.toString()
        textView6.text = " 使用者建議\n【得分說明】"+
                 "\n 1至10題之總分：\n" +
                " ☆得分0-13分:為一般正常範圍，表示身心適應狀況良好。\n" +
                " ☆得分13-25分:輕度情緒困擾，建議找家人或朋友談談，紓發情緒。\n" +
                " ☆得分26-38分:中度情緒困擾，建議尋求心理諮商或接受專業諮詢。\n" +
                " ☆得分38分以上或第11題得1分以上：重度情緒困擾，建議尋求心理諮商或接受精神科醫師治療。"

        //顯示分數
        val scoreTextView = findViewById<TextView>(R.id.math)

        // 取得來自test10的總分
        val totalScoreForm10 = intent.getIntExtra("totalScore", 0)


        val score11 = intent.getIntExtra("score", 0)//第11題
        scoreTextView.text = "第1-10的分數是:$totalScoreForm10 分 第11題的分數是：$score11 分"

        home_page.setOnClickListener {
            val it= Intent(this,HomeActivity::class.java)
            startActivity(it)
        }
    }
}