package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class BreathActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breath)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back3 = findViewById<ImageButton>(R.id.back3)

        val breathingInstructions = findViewById<TextView>(R.id.breathingInstructions)
        val startButton = findViewById<TextView>(R.id.startButton)


        // 初始文本
        breathingInstructions.text = "深呼吸練習\n\n請坐在一個舒適的位置，閉上眼睛。"

        // 設置按鈕的點擊監聽器
        startButton.setOnClickListener {
            // 隐藏按钮
            startButton.visibility = View.GONE

            // 創建计时器，控制深呼吸的節奏
            val breathingTimer = object : CountDownTimer(60000, 5000) {
                var breathCycle = 0

                //計時器會每5秒在文本視圖中顯示“深吸氣”或“深呼氣”，共進行6個循環，總計60秒，然後顯示“深呼吸練習完成！”。
                override fun onTick(millisUntilFinished: Long) {
                    // 根據 breathCycle 更新文本
                    when (breathCycle) {
                        0, 2, 4 -> {
                            breathingInstructions.text = "深呼吸"
                        }
                        1, 3 -> {
                            breathingInstructions.text = "慢慢吐氣"
                        }
                    }
                    breathCycle = (breathCycle + 1) % 5
                }

                override fun onFinish() {
                    breathingInstructions.text = "深呼吸練習完成！"
                    // 顯示按钮
                    startButton.visibility = View.VISIBLE
                }
            }

            // 啟動深呼吸練習
            breathingTimer.start()
        }







        back3.setOnClickListener {
            finish()
        }
    }
}