package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
//import com.example.mainactivity.databinding.ActivityNewBinding
//import com.example.mainactivity.databinding.ActivityTestBinding
//import com.google.firebase.firestore.FirebaseFirestore
import java.text.NumberFormat
import java.util.HashMap

class TestActivity : AppCompatActivity() {
    //private  var binding: ActivityTestBinding? =null
    //val fireStoreDatabase= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        //binding= ActivityTestBinding.inflate(layoutInflater)
        //setContentView(binding?.root)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val Next = findViewById<ImageButton>(R.id.Next)
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        val t0=findViewById<RadioGroup>(R.id.t0)
        content1.text = " 睡眠困難，譬如難以入睡、易醒或早醒"


        Next.setOnClickListener {
            // 取得所選擇的分數
            val score1 = when (t0.checkedRadioButtonId) {
                R.id.zero -> 0
                R.id.one -> 1
                R.id.two -> 2
                R.id.three -> 3
                R.id.four -> 4
                R.id.five -> 5
                else -> 0 // 如果未選擇，預設為0分
            }
            val intent = Intent(this, TestActivity2::class.java)
            intent.putExtra("score1", score1)
            startActivity(intent)
        }

        }
    }