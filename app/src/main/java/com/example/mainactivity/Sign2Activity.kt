package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class Sign2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign2)
        val btn_submit = findViewById<Button>(R.id.submit)
        val sexy = findViewById<RadioGroup>(R.id.sexy)
        val dialogBuilder = AlertDialog.Builder(this@Sign2Activity)

        btn_submit.setOnClickListener {
            AlertDialog.Builder(this)
                .setPositiveButton("OK"){ dialog, which->

                }
            val b = Bundle()
            b.putString("sexy", sexy.findViewById<RadioButton>
                    (sexy.checkedRadioButtonId).text.toString()
            )
        }
    }
}