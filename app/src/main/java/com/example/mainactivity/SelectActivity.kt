package com.example.mainactivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import com.example.mainactivity.databinding.ActivitySelectBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class SelectActivity : AppCompatActivity() {
    private var binding:ActivitySelectBinding?=null
    val fireStoreDatabase=FirebaseFirestore.getInstance()
    private var selectedDate: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //setContentView(R.layout.activity_select)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val btn=findViewById<ImageButton>(R.id.BTN)
        //val btn_rage = findViewById<ImageButton>(R.id.btn_range)
        val date_range=findViewById<TextView>(R.id.date_range)
        val diarylist=findViewById<TextView>(R.id.diarylist)
        binding!!.BTN.setOnClickListener() {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    selectedDate = setDateFormat(year, month, day)
                    val format = "$selectedDate"
                    date_range.text = format

                    fireStoreDatabase.collection("Diary")
                        .whereEqualTo("Today", selectedDate)
                        .get()
                        .addOnCompleteListener { task ->
                            val result: StringBuffer = StringBuffer()
                            if (task.isSuccessful) {
                                var count = 1
                                for (document in task.result!!) {
                                    val diaryContent = document.data.getValue("newdiary")
                                    result.append("$count. $diaryContent").append("\n")  // 在每则日记之后添加换行符
                                    count++
                                }
                                Log.d("FirestoreQuery", "Selected Date: $selectedDate, Result: $result")
                            } else {
                                Log.e("FirestoreQuery", "Error getting documents: ", task.exception)
                                binding?.diarylist?.setText("查無此紀錄")
                            }
                            binding?.diarylist?.setText(result.toString())
                        }
                }
            }, year, month, day).show()
        }


        val Back5 = findViewById<ImageButton>(R.id.back5)

        Back5.setOnClickListener {
            finish()

        }
    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${String.format("%02d", month + 1)}-${String.format("%02d", day)}"
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


