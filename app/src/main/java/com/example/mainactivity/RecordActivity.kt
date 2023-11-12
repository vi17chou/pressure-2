package com.example.mainactivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.mainactivity.databinding.ActivitySelectBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class RecordActivity : AppCompatActivity() {
    private var binding: ActivitySelectBinding?=null
    val fireStoreDatabase= FirebaseFirestore.getInstance()
    private var selectedDate: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val btn_rage = findViewById<ImageButton>(R.id.btn_range)
        val date_range=findViewById<TextView>(R.id.date_range)
        val diarylist = findViewById<TextView>(R.id.diarylist2)
        binding?.BTN?.setOnClickListener() {
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
                    fireStoreDatabase.collection("Diary")
                        .whereEqualTo("Today", selectedDate) // 添加过滤条件，只获取选择的日期
                        .get()
                        .addOnCompleteListener {
                            val result:StringBuffer=StringBuffer()
                            if (it.isSuccessful){
                                for (document in it.result!!)
                                    result//.append(document.data.getValue("Today")).append(" ")
                                        .append(document.data.getValue("測驗分數")).append(" ")
                            }
                            else{
                                binding?.diarylist?.setText("查無此紀錄")
                            }
                            binding?.diarylist?.setText(result)
                        }
                }
            }, year, month, day).show()

        }

        val Back2 = findViewById<ImageButton>(R.id.Back2)

        Back2.setOnClickListener {
            finish()

        }
    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

    /* private fun showDatePickerDialog() {
         val now = Calendar.getInstance()
         val dpd = DatePickerDialog.newInstance(
             this@SelectActivity,
             now.get(Calendar.YEAR),
             now.get(Calendar.MONTH),
             now.get(Calendar.DAY_OF_MONTH)
         )
         dpd.show(fragmentManager, "Datepickerdialog")*/
    }
