package com.example.mainactivity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DiaryActivity : AppCompatActivity() {
//123測試是否成功
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
    //設定隱藏標題
    getSupportActionBar()?.hide();
        val New=findViewById<ImageButton>(R.id.New)
        val select=findViewById<ImageButton>(R.id.select)
        val del=findViewById<ImageButton>(R.id.del)
        val back_home=findViewById<ImageButton>(R.id.back_home)

        fun edit(){
            val i = Intent(this,DiaryActivity::class.java)
            i.putExtra("key", true)
            startActivityForResult(i,1)
         }
        New.setOnClickListener {
            val intent =  Intent(this,NewActivity::class.java)
            startActivityForResult(intent,1)
        }

        select.setOnClickListener {
            val it= Intent(this,SelectActivity::class.java)
            startActivity(it)
        }
    val db = Room.databaseBuilder(this, AppDatabase::class.java,"user2.db").build()
        del.setOnClickListener {
            /*val it= Intent(this,DelActivity::class.java)
            startActivity(it)*/
            AlertDialog.Builder(this)
                .setTitle("刪除日記記錄")
                .setMessage("是否刪除所有日記記錄")
                .setNeutralButton("取消"){dialog,which->

                }
                .setPositiveButton("刪除"){dialog,which->
                }.show()
        }


        back_home.setOnClickListener {
            finish()
        }
    }
}