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


        Next.setOnClickListener {v->
            val b = Bundle()
            //27 寫6變
            b.putInt("zero",0)
            b.putInt("one",1)
            b.putInt("two",2)
            b.putInt("three",3)
            b.putInt("four",4)
            b.putInt("five",5)

            val it = Intent(this, TestActivity2::class.java)
            intent.putExtras(b)
            startActivity(it)
        }
    }
}



/*
            b.putExtras("one",1)
            b.putExtras("two",2)
            b.putExtras("three",3)
            b.putExtras("four",4)
            b.putExtras("five",5)

            private fun Bundle.putExtras(s: String, i: Int) {

}

private fun Intent.putExtras(s: String, i: Int) {

}*/