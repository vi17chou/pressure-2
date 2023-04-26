package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.Calendar





class SelectActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)


        val btn_rage = findViewById<Button>(R.id.btn_range)

        btn_rage.setOnClickListener {
            showDatePickerDialog()
        }
        val Back2 = findViewById<Button>(R.id.Back2)

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
