package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_method)
        val game = findViewById<Button>(R.id.game)
        val breath = findViewById<Button>(R.id.breath)
        val sport = findViewById<Button>(R.id.sport)
        val emotion = findViewById<Button>(R.id.emotion)
        val diet = findViewById<Button>(R.id.diet)
        val back = findViewById<Button>(R.id.back)

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
        back.setOnClickListener { v ->
            val it = Intent(this, HomeActivity::class.java).apply {

            }
        }
    }
}