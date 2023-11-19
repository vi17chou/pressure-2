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
            val userid = getUserIdFromYourDatabase("User_id")

            if (userid != null) {
                // 創建包含使用者ID的日記數據
                val diary = hashMapOf(
                    "User_id" to userid,
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
            } else {
                // 如果無法取得使用者ID，進行相應的處理
                // 例如彈出錯誤訊息，處理失敗情況
            }
        }
    }

    private fun getUserIdFromYourDatabase(account: String): String? {
        var userId: String? = null

        // 在這裡執行查詢操作，根據Account查詢User資料表，並取得對應的user_id
        // 這裡僅是一個簡單的例子，實際情況需要根據你的資料庫結構和邏輯進行修改

        // 注意: 以下的程式碼僅為示範，實際上應使用異步操作，不應在主線程中執行，以避免阻塞UI
        val query = fireStoreDatabase.collection("Users").whereEqualTo("Account", account)
        query.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    // 找到匹配的資料
                    userId = document.getString("user_id")
                    break
                }

                if (userId != null) {
                    // 成功取得 user_id，可以在這裡進行相應的處理
                } else {
                    // 未找到匹配的資料，進行相應的處理
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
                // 發生錯誤，進行相應的處理
            }

        // 注意: 這裡不能立即返回 userId，因為 Firestore 的查詢是異步的，你需要等待查詢完成後再使用 userId
        return userId
    }
}