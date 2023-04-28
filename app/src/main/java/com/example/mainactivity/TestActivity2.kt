package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        content1.text = "感覺緊張不安"

        val t1 = findViewById<RadioGroup>(R.id.t1)
        val T02=findViewById<TextView>(R.id.T02)
            //接收上一個頁面傳過來的數值，利用intent接收
        
        Next.setOnClickListener {
            val b = Bundle()
            b.putInt("zero",0)
            b.putInt("one",1)
            b.putInt("two",2)
            b.putInt("three",3)
            b.putInt("four",4)
            b.putInt("five",5)
            val it = Intent(this, TestActivity3::class.java)
            intent.putExtras(b)
            startActivity(it)
        }

    }
}


private operator fun Int.plus(b: Bundle) {

}
