package com.example.mainactivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.*

private lateinit var btn_submit:ImageButton
private lateinit var btn_date:ImageButton
private lateinit var sex:RadioGroup
private lateinit var account:TextView
private lateinit var password:TextView
private lateinit var check_pwd:TextView
private lateinit var name:TextView
private lateinit var age:TextView
class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        btn_submit=findViewById<ImageButton>(R.id.btn_submit)
        sex = findViewById<RadioGroup>(R.id.sexy)
        btn_date=findViewById<ImageButton>(R.id.btn_date)
        age=findViewById<TextView>(R.id.age)
        name=findViewById<TextView>(R.id.name)
        account=findViewById<TextView>(R.id.sign_account)
        password=findViewById<TextView>(R.id.sign_password)
        check_pwd=findViewById<TextView>(R.id.checkpwd)


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
            //val b = Bundle()
            with(getPreferences(MODE_PRIVATE).edit()){
                putString("sex",sex.findViewById<RadioButton>
                    (sex.checkedRadioButtonId).text.toString())
                    putString("na",name.getText().toString())
                    putString("ag",age.getText().toString())
                    putString("sign_acc", account.getText().toString())
                    putString("sign_pwd", password.getText().toString())
                    putString("check_pwd",check_pwd.getText().toString())
                    apply()
            }
            //setResult(RESULT_OK, Intent().putExtras(b))
            finish()
        }

    }

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }

}