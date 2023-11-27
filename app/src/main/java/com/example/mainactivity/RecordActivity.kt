package com.example.mainactivity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.mainactivity.databinding.ActivityRecordBinding
import com.example.mainactivity.databinding.ActivitySelectBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import java.util.*

class RecordActivity : AppCompatActivity() {

    private var binding: ActivityRecordBinding? = null
    private val fireStoreDatabase = FirebaseFirestore.getInstance()
    private var selectedDate: String? = null
    private var isClickHandled = false


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // setContentView(R.layout.activity_record)
        //設定隱藏標題
        getSupportActionBar()?.hide();

        val btn = findViewById<ImageButton>(R.id.BTN)
        //val btn_rage = findViewById<ImageButton>(R.id.btn_range)
        val date_range = findViewById<TextView>(R.id.date_range)
        val diarylist2 = findViewById<TextView>(R.id.diarylist2)
        btn.setOnClickListener {
            if (!isClickHandled) {
                isClickHandled = true
                //showDatePickerDialog()
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(this, { _, year, month, day ->
                    run {
                        selectedDate = setDateFormat(year, month, day)
                        val format = "$selectedDate"
                        date_range.text = format

                        fireStoreDatabase.collection("Test")
                            .whereEqualTo("test_today", selectedDate) // 添加过滤条件，只获取选择的日期
                            .get()
                            .addOnCompleteListener { task ->
                                val result: StringBuffer = StringBuffer()
                                if (task.isSuccessful) {
                                    var field1Displayed = false
                                    var field2Displayed = false

                                    for (document in task.result!!) {
                                        if (!field1Displayed) {
                                            val field1 = document.getLong("前十題總分") //前十題總分
                                            result.append("前十題總分: ").append(field1 ?: "未知")
                                                .append("\n ")
                                            field1Displayed = true
                                        }

                                        if (!field2Displayed) {
                                            val field2 = document.getLong("第十一題分數") // 第十一題的分數
                                            result.append("第十一題分數: ").append(field2 ?: "未知")
                                                .append(" ")
                                            field2Displayed = true
                                        }
                                        if (field1Displayed && field2Displayed) {
                                            break  // 已经顯示了兩個字段，不再其他文档
                                        }
                                    }

                                } else {
                                    Log.e(
                                        "FirestoreQuery",
                                        "Error getting documents: ",
                                        task.exception
                                    )
                                    binding?.diarylist2?.setText("查無此紀錄")
                                }
                                binding?.diarylist2?.setText(result.toString())
                                // 重置 isClickHandled，以便用户可以选择新的日期
                                isClickHandled = false
                            }
                    }
                }, year, month, day).show()

            }


            val Back2 = findViewById<ImageButton>(R.id.Back2)

            Back2.setOnClickListener {
                finish()

            }
        }
        /*   private fun setDateFormat(year: Int, month: Int, day: Int): String? {
            return "$year-${month + 1}-$day"
        }*/

    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String? {
        return "$year-${month + 1}-$day"
    }

}
