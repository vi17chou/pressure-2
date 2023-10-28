package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mainactivity.databinding.ActivityNewBinding
import com.example.mainactivity.databinding.ActivityTest11Binding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap

class TestActivity11 : AppCompatActivity() {
    private  var binding: ActivityTest11Binding? =null
    val fireStoreDatabase= FirebaseFirestore.getInstance()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest11Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        // 設定隱藏標題
        supportActionBar?.hide()

        val submit = findViewById<ImageButton>(R.id.submit)
        val t10 = findViewById<RadioGroup>(R.id.t10)
        val previous_question=findViewById<ImageButton>(R.id.previous_question)
        // 題目
        val content1 = findViewById<TextView>(R.id.content2)
        content1.text = "有自殺的想法"

        var test2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val mydata: Intent? = result.data
                if (mydata != null) {
                    Log.d("twoActivity", "Mydata:" + mydata.getStringExtra("result"))
                }
            }
        }

        previous_question.setOnClickListener {
            finish()
        }

        // 從 test9 接收分數（score1+score2+score3+score4+score5+score6+score7+score8+score9+score10）
        val totalScoreFrom10 = intent.getIntExtra("totalScore", 0)


        submit.setOnClickListener {
            // 根據選定的RadioButton獲取分數
            val score11 = when (t10.checkedRadioButtonId) {
                R.id.zero -> 0
                R.id.one -> 1
                R.id.two -> 2
                R.id.three -> 3
                R.id.four -> 4
                R.id.five -> 5
                // 如果需要，為其他單選按鈕添加更多案例
                else -> 0 // 如果未選擇則 0 分
            }
            val test = hashMapOf(
                "前十題總分" to "${totalScoreFrom10}",
                "第十一題分數" to "${score11}"
            )
            val Test:MutableMap<String,Any> = HashMap()

            Test["前十題總分"]=totalScoreFrom10
            Test["第十一題分數"]=score11
            fireStoreDatabase.collection("Test")
                .add(Test)
                .addOnSuccessListener {
                    Log.d(TAG,"Added document with Id ${it.id}")
                }
                .addOnFailureListener {
                    Log.w(TAG,"Error adding document ${it}")
                }
            // 計算所有11項活動的總分
            // val totalScore = totalScoreFrom10 + score11


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("score", score11) // 第十一題的分數
            intent.putExtra("totalScore", totalScoreFrom10)//前十題總分
            startActivity(intent)

        }
    }
}