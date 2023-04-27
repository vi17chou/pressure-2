package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val home_page=findViewById<Button>(R.id.home_page)
        val textView6 = findViewById<TextView>(R.id.tips)
        val textViewString = textView6.text.toString()
        textView6.text = " 使用者建議\n【得分說明】"+
                 "\n 1至10題之總分：\n" +
                " ☆得分0-10分:為一般正常範圍，表示身心適應狀況良好。\n" +
                " ☆得分11-18分:輕度情緒困擾，建議找家人或朋友談談，紓發情緒。\n" +
                " ☆得分19-28分:中度情緒困擾，建議尋求心理諮商或接受專業諮詢。\n" +
                " ☆得分29分以上或第11題得1分以上：重度情緒困擾，建議尋求心理諮商或接受精神科醫師治療。"



        home_page.setOnClickListener {
            val it= Intent(this,HomeActivity::class.java)
            startActivity(it)
        }
    }
}