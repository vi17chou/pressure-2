package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class TestActivity11 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test11)
        val submit = findViewById<ImageButton>(R.id.submit)
        val previous_question=findViewById<ImageButton>(R.id.previous_question)

        //題目
        val content1 = findViewById<TextView>(R.id.content2)
        val textViewString = content1.text.toString()
        content1.text = "有自殺的想法"

        var test2=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
            if(result.resultCode== RESULT_OK){
                val mydata:Intent?=result.data
                if (mydata!=null){
                    Log.d("twoActivity","Mydata:"+mydata.getStringExtra("result"))
                }
            }
        }
        previous_question.setOnClickListener {
           finish()
        }

        //test2.launch(it)

        submit.setOnClickListener {
            val it = Intent(this, ResultActivity::class.java)
            startActivity(it)
        }
    }
}