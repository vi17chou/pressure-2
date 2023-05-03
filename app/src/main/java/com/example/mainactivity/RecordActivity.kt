package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import java.util.*

class RecordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val btn_rage = findViewById<ImageButton>(R.id.btn_range)

        btn_rage.setOnClickListener {
            showDatePickerDialog()
        }

        val Back2 = findViewById<ImageButton>(R.id.Back2)

        Back2.setOnClickListener {
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