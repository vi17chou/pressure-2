package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Diet_food6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_food6)

        //設定隱藏標題
        getSupportActionBar()?.hide();
        val back3 = findViewById<ImageButton>(R.id.back3)

        //食物名稱
        val foodname = findViewById<TextView>(R.id.foodname)
        foodname.text = "橙色水果和蔬菜：如甜橙、胡蘿蔔和南瓜等"
        //營養成分
        val Element = findViewById<TextView>(R.id.Element)
        Element.text = "這些食物中含有大量的抗氧化物和維生素C"

        //功效
        val effect = findViewById<TextView>(R.id.effect)
        effect.text = "有助於降低身體的壓力反應"

        back3.setOnClickListener {
            finish()
        }
    }
}