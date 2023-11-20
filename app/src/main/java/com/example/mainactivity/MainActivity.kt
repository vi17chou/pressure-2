package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

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
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (validateCredentials(enteredUsername, enteredPassword)) {
                // 如果是管理员账号，跳转到 backstage_main 页面
                if (enteredUsername == adminUsername && enteredPassword==adminPassword) {
                    val intent = Intent(this, backstage_main::class.java)
                    startActivity(intent)
                }
            } else {
                val intent = Intent(this,ExplainActivity::class.java)
                startActivity(intent)
            }
        }

        sign.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }
    }


    private fun validateCredentials(username: String, password: String): Boolean {
        // 检查帐号密码是否与管理员帐号密码匹配
        return username == adminUsername && password == adminPassword
    }
}