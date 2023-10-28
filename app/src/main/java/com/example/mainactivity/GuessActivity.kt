package com.example.mainactivity

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GuessActivity : AppCompatActivity() {

    private lateinit var answer: String
    private lateinit var inputEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var historyInputTextView: TextView
    private lateinit var historyResultTextView: TextView
    private var historyInput: String = ""
    private var historyResult: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        //設定隱藏標題
        getSupportActionBar()?.hide();

        answer = generateRandomNumber()

        inputEditText = findViewById(R.id.number)
        resultTextView = findViewById(R.id.history_result)
        historyInputTextView = findViewById(R.id.history_input)
        historyResultTextView = findViewById(R.id.history_result)

        val submitButton = findViewById<ImageButton>(R.id.guess_submit)
        submitButton.setOnClickListener {
            checkGuess()
        }

    }

    // 生成随機的4位數字
    private fun generateRandomNumber(): String {
// 建立一個包含0到9的數字的可變列表
        val digits = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
// 打乱数字的顺序，以便生成随机的4位数字
        digits.shuffle()
// 返回生成的随机4位数字
        return digits.take(4).joinToString("")

    }

    // 檢查猜測是否正确
    private fun checkGuess() {
        val guess = inputEditText.text.toString()
        if (guess.length != 4 || !guess.all { it.isDigit() }) {
// 如果輸入的不是有效的4位數字，顯示錯誤消息並返回
            resultTextView.text = "請输入有效的4位数字"
            return
        }

        var aCount = 0
        var bCount = 0

        for (i in 0 until 4) {
            if (guess[i] == answer[i]) {
                aCount++
            } else if (answer.contains(guess[i])) {
                bCount++
            }
        }



//顯示猜測結果
        val result = "$aCount A $bCount B"
        resultTextView.text = result

        // 將猜測和结果加到歷史紀錄
        historyInput += "$guess\n"
        historyResult += "$result\n"

        // 更新歷史紀錄
        historyInputTextView.text = historyInput
        historyResultTextView.text = historyResult

        // 檢查是否猜對
        if (aCount == 4) {
            // 如果猜對了所有4位數字

            showResultDialog("You win")
        }

    }

    private fun showResultDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("结果")
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("确定") { dialog, which ->
            dialog.dismiss()
            if (message == "You win") {
                // 如果猜对了所有4位数字，可以执行相应的操作
            }
        }
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.show()
    }


}





