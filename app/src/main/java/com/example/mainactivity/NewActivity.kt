package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val cancel = findViewById<Button>(R.id.btn_cancel)
        val save = findViewById<Button>(R.id.btn_save)
        val new_diary = findViewById<TextView>(R.id.new_diary)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.getTime())
        val today = findViewById<TextView>(R.id.today)
        today.text = s

        cancel.setOnClickListener {
            finish()
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