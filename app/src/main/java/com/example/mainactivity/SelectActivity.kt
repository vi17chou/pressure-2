package com.example.mainactivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.*





class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val btn=findViewById<ImageButton>(R.id.BTN)
        //val btn_rage = findViewById<ImageButton>(R.id.btn_range)
        val date_range=findViewById<TextView>(R.id.date_range)
        btn.setOnClickListener {
            //showDatePickerDialog()
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    val format = "${setDateFormat(year, month, day)}"
                    date_range.text = format
                }
            }, year, month, day).show()
        }

        val Back5 = findViewById<ImageButton>(R.id.back5)

        Back5.setOnClickListener {
            finish()

        }
    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

    /* val btn_rage = findViewById<ImageButton>(R.id.btn_range)

     btn_rage.setOnClickListener {
         showDatePickerDialog()
     }
     private fun showDatePickerDialog() {
         val now = Calendar.getInstance()
         val dpd = DatePickerDialog.newInstance(
             this@SelectActivity,
             now.get(Calendar.YEAR),
             now.get(Calendar.MONTH),
             now.get(Calendar.DAY_OF_MONTH)
         )
         dpd.show(fragmentManager, "Datepickerdialog")*/
    }


