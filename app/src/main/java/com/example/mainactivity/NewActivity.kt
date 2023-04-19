package com.example.mainactivity

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
        val cancel=findViewById<Button>(R.id.btn_cancel)
        val save=findViewById<Button>(R.id.btn_save)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.getTime())
        val today=findViewById<TextView>(R.id.today)
        today.text=s

        cancel.setOnClickListener {
            finish()
        }

        save.setOnClickListener {
            val b = Bundle()
            b.putString("now_date",today.getText().toString())
            setResult(RESULT_OK, Intent().putExtras(b))
            finish()
        }
    }
}