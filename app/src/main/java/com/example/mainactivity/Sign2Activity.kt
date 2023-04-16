package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Sign2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign2)
        //日期製造器
        //date_edit.setOnClickListener(listener)
        val name=findViewById<TextView>(R.id.name)
        val age=findViewById<TextView>(R.id.age)
        val sexy=findViewById<RadioGroup>(R.id.sexy)

        val b = Bundle()
        b.putString("na",name.getText().toString())
        b.putString("ag",age.getText().toString())
        b.putString("sex",sexy.findViewById<RadioButton>
            (sexy.checkedRadioButtonId).text.toString())
        setResult(RESULT_OK, Intent().putExtras(b))
        finish()
    }
}