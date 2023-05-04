package com.example.mainactivity

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.*

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val btn_submit=findViewById<ImageButton>(R.id.btn_submit)
        val sex = findViewById<RadioGroup>(R.id.sexy)
        val btn_date=findViewById<ImageButton>(R.id.btn_date)
        val age=findViewById<TextView>(R.id.age)
        val name=findViewById<TextView>(R.id.name)
        val acc=findViewById<TextView>(R.id.sign_account)
        val pwd=findViewById<TextView>(R.id.sign_password)
        val checkpwd=findViewById<TextView>(R.id.checkpwd)


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
            b.putString("sign_acc",acc.getText().toString())
            b.putString("sign_pwd",pwd.getText().toString())
            b.putString("check_pwd",checkpwd.getText().toString())
            setResult(RESULT_OK, Intent().putExtras(b))
            finish()
        }
    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

}