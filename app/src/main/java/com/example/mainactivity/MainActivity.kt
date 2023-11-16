package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    // 假设这是您的管理员帐号密码
    private val adminUsername = "admin"
    private val adminPassword = "admin123"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val login=findViewById<ImageButton>(R.id.login)
        val sign=findViewById<ImageButton>(R.id.sign)
        //val mng=findViewById<Button>(R.id.mng)

        val usernameEditText = findViewById<EditText>(R.id.acc)
        val passwordEditText = findViewById<EditText>(R.id.pwd)

        login.setOnClickListener {
         /*   //  val it=Intent(this,ExplainActivity::class.java)測驗題目先跳過不然每次都要點11題很浪費時間
            val it=Intent(this,TestActivity::class.java)
            startActivity(it)*/

            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (validateCredentials(enteredUsername, enteredPassword)) {
                val it = Intent(this, backstage_main::class.java)
                intent.putExtra("Account", enteredUsername)
                startActivity(it)
            } else {
                val it = Intent(this, HomeActivity::class.java)
                startActivity(it)
            }
        }


        sign.setOnClickListener {
            val it=Intent(this,SignActivity::class.java)
            startActivity(it)
        }
       /* mng.setOnClickListener {
            val it=Intent(this,backstage_main::class.java)
            startActivity(it)
        }*/
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // 假設這是您的管理者帳號密碼
        val adminUsername = "admin"
        val adminPassword = "admin123"
        // 檢查帳號密碼是否與管理者帳號密碼相符
        return username == adminUsername && password == adminPassword
    }
}