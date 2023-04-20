package com.example.mainactivity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.Calendar

class Sign2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign2)
        val btn_submit = findViewById<Button>(R.id.submit)
        val sex = findViewById<RadioGroup>(R.id.sexy)
        val btn_date=findViewById<Button>(R.id.btn_date)
        val age=findViewById<TextView>(R.id.age)
        val name=findViewById<TextView>(R.id.name)


        btn_date.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    val format = "${setDateFormat(year, month, day)}"
                    age.text = format
                }
            }, year, month, day).show()
        }

        btn_submit.setOnClickListener {
            val b = Bundle()
            b.putString("sex",sex.findViewById<RadioButton>
                (sex.checkedRadioButtonId).text.toString())
            b.putString("na",name.getText().toString())
            b.putString("ag",age.getText().toString())
            setResult(RESULT_OK, Intent().putExtras(b))
            finish()

                /*val it = Intent(this,MainActivity::class.java)
                startActivity(it)*/
        }
    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }
}