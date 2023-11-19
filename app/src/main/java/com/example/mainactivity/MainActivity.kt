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
    private var loginAttempts = 0
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

            /*if (validateCredentials(enteredUsername, enteredPassword)) {
                // 检查用户是否有測驗紀錄
                if (checkUserHasTestRecord(enteredUsername)) {
                    // 如果有測驗紀錄，跳转到 HomeActivity
                    val it = Intent(this, HomeActivity::class.java)
                    it.putExtra("Account", enteredUsername)
                    startActivity(it)
                } else {
                    // 如果没有測驗紀錄，检查登录尝试次数
                    loginAttempts
                    loginAttempts++
                    if (loginAttempts < 3) {
                        Toast.makeText(
                            this,
                            "Invalid credentials. Attempts left: ${3 - loginAttempts}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "You've reached the maximum login attempts. Please take the test.",
                            Toast.LENGTH_SHORT
                        ).show()

                        // 重置登录尝试次数
                        loginAttempts = 0

                        // 进行測驗
                        val it = Intent(this, TestActivity::class.java)
                        startActivity(it)
                    }
                }
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }*/
            val it = Intent(this, TestActivity::class.java)
            startActivity(it)
        }

        sign.setOnClickListener {
            val it = Intent(this, SignActivity::class.java)
            startActivity(it)
        }
    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // 假設這是您的管理者帳號密碼
        val adminUsername = "admin"
        val adminPassword = "admin123"
        // 檢查帳號密碼是否與管理者帳號密碼相符
        return username == adminUsername && password == adminPassword
    }
    private fun checkUserHasTestRecord(username: String): Boolean {
        // 在这里添加代码来检查用户是否有測驗紀錄
        // 如果有測驗紀錄，返回 true；否则返回 false
        // 你需要替换下面的示例代码为实际的数据库查询逻辑
        return username == "user_with_test_record"
    }
}