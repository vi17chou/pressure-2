package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val game = findViewById<ImageButton>(R.id.game)
        val breath = findViewById<ImageButton>(R.id.breath)
        val sport = findViewById<ImageButton>(R.id.sport)
        val emotion = findViewById<ImageButton>(R.id.emotion)
        val diet = findViewById<ImageButton>(R.id.diet)
        val back = findViewById<ImageButton>(R.id.back)

        //小遊戲
        game.setOnClickListener {
            val it = Intent(this, GameActivity::class.java)
            startActivity(it)
        }

        //深呼吸
        breath.setOnClickListener {
            val it = Intent(this, BreathActivity::class.java)
            startActivity(it)
        }

        //運動
        sport.setOnClickListener {
            val it = Intent(this, SportActivity::class.java)
            startActivity(it)
        }

        //控制情緒
        emotion.setOnClickListener {
            val it = Intent(this, EmotionActivity::class.java)
            startActivity(it)
        }
        //控制情緒
        diet.setOnClickListener {
            val it = Intent(this, DietActivity::class.java)
            startActivity(it)
        }

        //返回
        back.setOnClickListener {
            finish()
        }
    }
}