package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_del)
        //設定隱藏標題
        getSupportActionBar()?.hide();
    }
}