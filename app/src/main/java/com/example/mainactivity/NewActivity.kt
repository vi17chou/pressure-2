package com.example.mainactivity

import android.media.metrics.Event
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mainactivity.databinding.ActivityNewBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import java.util.Calendar
import java.util.HashMap

class NewActivity : AppCompatActivity() {
    private  var binding: ActivityNewBinding? =null
    val fireStoreDatabase= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //設定隱藏標題
        getSupportActionBar()?.hide();
        val cancel = findViewById<ImageButton>(R.id.btn_cancel)
        val save = findViewById<ImageButton>(R.id.btn_save)
        var new_diary = findViewById<TextView>(R.id.txt_newdiary)
        val mCal: Calendar = Calendar.getInstance()
        val s: CharSequence = DateFormat.format("yyyy-MM-dd", mCal.getTime())
        val today = findViewById<TextView>(R.id.txt_today)
        today.text = s
        //val db = Room.databaseBuilder(this, AppDatabase::class.java,"user2.db").build()

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
            //連線外部資料庫
                var today:String=binding!!.txtToday.text.toString()
                var newdiary:String=binding!!.txtNewdiary.text.toString()
            val diary = hashMapOf(
                "Today" to "${today}",
                "newdiary" to "${newdiary}"
            )
                val Diary:MutableMap<String,Any> = HashMap()
                    fireStoreDatabase.collection("Diary")
                        .add(Diary)
                        .addOnSuccessListener {documentReference ->
                            Log.d(TAG, "DocumentSnapshot successfully written!${documentReference.id}") }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error writing document", e) }

                    Diary["Today"]=today
                    Diary["newdiary"]=newdiary
                    fireStoreDatabase.collection("Diary")
                        .add(Diary)
                        .addOnSuccessListener {
                         Log.d(TAG,"Added document with Id ${it.id}")
                        }
                         .addOnFailureListener {
                         Log.w(TAG,"Error adding document ${it}")
                        }
            binding!!.txtToday.text.toString()
            binding!!.txtNewdiary.text.toString()
            finish()

        }
            //val b = Bundle()
            /*with(getPreferences(MODE_PRIVATE).edit()){
                putString("write_diary", new_diary.getText().toString())
                putString("now_date", today.getText().toString())
                apply()
            }
            //setResult(RESULT_OK, Intent().putExtras(b))
            finish()*/
        /*原本存取資料寫法
              val content = new_diary.text.toString()
              GlobalScope.launch{
                  val row=db.diaryDao().insert(Diary(content = content, mTime = LocalDateTime.now()))
                  if(row > 0){
                      Snackbar.make(it, "新增成功！$row", Snackbar.LENGTH_LONG).show()
                      finish()
                  }
              }*/
        }
    }