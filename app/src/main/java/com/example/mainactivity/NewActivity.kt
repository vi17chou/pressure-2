package com.example.mainactivity

import android.annotation.SuppressLint
import android.media.metrics.Event
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainactivity.databinding.ActivityNewBinding
import com.google.android.play.integrity.internal.i
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Calendar
import java.util.HashMap

private fun CharSequence.clear() {
    TODO("Not yet implemented")
}

class NewActivity : AppCompatActivity() {
    private var binding: ActivityNewBinding? = null
    val fireStoreDatabase = FirebaseFirestore.getInstance()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // 設定隱藏標題
        supportActionBar?.hide()

        val cancel = findViewById<ImageButton>(R.id.btn_cancel)
        val save = findViewById<ImageButton>(R.id.btn_save)
        val newDiary = findViewById<TextView>(R.id.txt_newdiary)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.time)
        val today = findViewById<TextView>(R.id.txt_today)
        today.text = s

        cancel.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("取消新增日記")
                .setMessage("是否確定取消填寫日記")
                .setNeutralButton("否") { dialog, which ->

                }
                .setPositiveButton("是") { dialog, which ->

                    finish()
                }.show()
        }

        save.setOnClickListener {
            val today: String = binding!!.txtToday.text.toString()
            val newdiary: String = binding!!.txtNewdiary.text.toString()

            // 假設你的 User 表格中有 user_id，這裡取得它（請替換為你實際的取得 user_id 的方法）

                // 創建包含使用者ID的日記數據
                val diary = hashMapOf(
                    "Today" to today,
                    "newdiary" to newdiary
                )

                // 將日記添加到 Firestore 中
                fireStoreDatabase.collection("Diary")
                    .add(diary)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "Added document with Id ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

                binding!!.txtToday.text.clear()
                binding!!.txtNewdiary.text.clear()
                finish()
            }
        }
    }