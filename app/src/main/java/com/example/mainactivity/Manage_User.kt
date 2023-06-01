package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class Manage_User : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        val New=findViewById<Button>(R.id.New)
        val select=findViewById<Button>(R.id.select)
        val del=findViewById<Button>(R.id.del)
        val back_home=findViewById<Button>(R.id.back_home)

        fun edit(){
            val i = Intent(this,Manage_User::class.java)
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

        del.setOnClickListener {
            /*val it= Intent(this,DelActivity::class.java)
            startActivity(it)*/
            AlertDialog.Builder(this)
                .setTitle("刪除使用者帳號")
                .setMessage("是否刪除帳號")
                .setNeutralButton("取消"){dialog,which->

                }
                .setPositiveButton("刪除"){dialog,which->
                    //val db=DBHelper(context).writableDatabase
                    //db.execSQL("DELETE FROM Notes WHERE id LIKE ${data[position].id}")
                }.show()
        }


        back_home.setOnClickListener {
            finish()
        }
    }
}