package com.example.mainactivity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.view.View
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

private lateinit var btn_submit:ImageButton
private lateinit var btn_date:ImageButton
private lateinit var sex:RadioGroup
private lateinit var account:TextView
private lateinit var password:TextView
private lateinit var check_pwd:TextView
private lateinit var name:TextView
private lateinit var age:TextView
private lateinit var eye:ImageView
private lateinit var checkeye:ImageView

class SignActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        //設定隱藏標題
        getSupportActionBar()?.hide();

        btn_submit=findViewById<ImageButton>(R.id.btn_submit)//送出
        sex = findViewById<RadioGroup>(R.id.sexy)//性別
        btn_date=findViewById<ImageButton>(R.id.btn_date)//出生日期
        age=findViewById<TextView>(R.id.age)//年齡
        name=findViewById<TextView>(R.id.name)//姓名
        account=findViewById<TextView>(R.id.sign_account)//帳號
        password=findViewById<TextView>(R.id.sign_password)//密碼
        check_pwd=findViewById<TextView>(R.id.checkpwd)//確認密碼

        val db=Room.databaseBuilder(this,AppDatabase::class.java,"mysqlite.db").build()

        eye=findViewById<ImageView>(R.id.eye)
        checkeye=findViewById<ImageView>(R.id.checkeye)


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
            val name=name.text.toString()
            val account= account.text.toString()
            val password=password.text.toString()
            val check_pwd=check_pwd.text.toString()
            GlobalScope.launch {
                val rowid=db.userDao().insert((user(name = name, acoount = account, password = password, check_pwd = check_pwd)))
                if (rowid>0){
                    Snackbar.make(it, "新增成功！$rowid", Snackbar.LENGTH_LONG).show()
                }
            }
            //val b = Bundle()
            /*with(getPreferences(MODE_PRIVATE).edit()){
                putString("sex",sex.findViewById<RadioButton>
                    (sex.checkedRadioButtonId).text.toString())
                    putString("na",name.getText().toString())
                    putString("ag",age.getText().toString())
                    putString("sign_acc", account.getText().toString())
                    putString("sign_pwd", password.getText().toString())
                    putString("check_pwd",check_pwd.getText().toString())
                    apply()
            }*/
            //setResult(RESULT_OK, Intent().putExtras(b))
            finish()
        }


        //密碼
        var isHideFirst = true
        eye.setOnClickListener {
            if (isHideFirst === true) {
                eye.setImageResource(R.drawable.eye)
                //密文
                val method1 =
                    HideReturnsTransformationMethod.getInstance()
                password.setTransformationMethod(method1)
                isHideFirst = false
            } else {
                eye.setImageResource(R.drawable.closeeye)
                //密文
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                password.setTransformationMethod(method)
                isHideFirst = true
            }
            // 光标的位置
            // 光标的位置
            val index: Int = password.getText().toString().length
            password.setSelection(index)

        }
        //確認密碼
        var isHideFirst1 = true
        checkeye.setOnClickListener {
            if (isHideFirst1 === true) {
                checkeye.setImageResource(R.drawable.eye)
                //密文
                val method1 =
                    HideReturnsTransformationMethod.getInstance()
                check_pwd.setTransformationMethod(method1)
                isHideFirst1 = false
            } else {
                checkeye.setImageResource(R.drawable.closeeye)
                //密文
                val method: TransformationMethod = PasswordTransformationMethod.getInstance()
                check_pwd.setTransformationMethod(method)
                isHideFirst1 = true
            }

            val index: Int = check_pwd.getText().toString().length
            check_pwd.setSelection(index)

        }

    }

}


private fun TextView.setSelection(index: Int) {

}

    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }




