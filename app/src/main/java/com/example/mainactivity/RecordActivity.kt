package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.*

class RecordActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val btn_rage = findViewById<Button>(R.id.btn_range)
        val back_home=findViewById<Button>(R.id.back_home)
        btn_rage.setOnClickListener {
            showDatePickerDialog()
        }

        back_home.setOnClickListener {
            finish()
        }
    }

        private fun showDatePickerDialog() {
            val now = Calendar.getInstance()
            /*val dpd = DatePickerDialog.newInstance(
            this@SelectActivity,
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH)
        )
        dpd.show(fragmentManager, "Datepickerdialog")*/
        }

    }