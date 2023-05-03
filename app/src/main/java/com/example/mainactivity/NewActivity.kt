package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val cancel = findViewById<ImageButton>(R.id.btn_cancel)
        val save = findViewById<ImageButton>(R.id.btn_save)
        val new_diary = findViewById<TextView>(R.id.new_diary)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.getTime())
        val today = findViewById<TextView>(R.id.today)
        today.text = s

        cancel.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("取消新增日記")
                .setMessage("是否確定取消填寫日記")
                .setNeutralButton("否"){dialog,which->

                }
                .setPositiveButton("是"){dialog,which->
                    //val db=DBHelper(context).writableDatabase
                    //db.execSQL("DELETE FROM Notes WHERE id LIKE ${data[position].id}")
                    finish()
                }.show()
            //finish()
        }

        save.setOnClickListener {
            val b = Bundle()
            b.putString("write_diary", new_diary.getText().toString())
            b.putString("now_date", today.getText().toString())
            setResult(RESULT_OK, Intent().putExtras(b))
            finish()

        }
    }
}