package com.example.mainactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.Calendar

private  lateinit var new_diary:TextView
class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val cancel = findViewById<ImageButton>(R.id.btn_cancel)
        val save = findViewById<ImageButton>(R.id.btn_save)
        new_diary = findViewById<TextView>(R.id.new_diary)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.getTime())
        val today = findViewById<TextView>(R.id.today)
        today.text = s
        val db = Room.databaseBuilder(this, AppDatabase::class.java,"user2.db").build()

        cancel.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("取消新增日記")
                .setMessage("是否確定取消填寫日記")
                .setNeutralButton("否"){dialog,which->

                }
                .setPositiveButton("是"){dialog,which->
                    //val db=DBHelper(context).writableDatabase
                    //db.execSQL("DELETE FROM Notes WHERE id LIKE ${data[position].id}")
                    finish()
                }.show()
            //finish()
        }

        save.setOnClickListener {
            val content = new_diary.text.toString()
            GlobalScope.launch{
                val row=db.diaryDao().insert(Diary(content = content, mTime = LocalDateTime.now()))
                if(row > 0){
                    Snackbar.make(it, "新增成功！$row", Snackbar.LENGTH_LONG).show()
                    finish()
                }
            }
        }
            //val b = Bundle()
            /*with(getPreferences(MODE_PRIVATE).edit()){
                putString("write_diary", new_diary.getText().toString())
                putString("now_date", today.getText().toString())
                apply()
            }
            //setResult(RESULT_OK, Intent().putExtras(b))
            finish()*/

        }
    }