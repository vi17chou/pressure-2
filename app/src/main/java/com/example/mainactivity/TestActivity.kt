package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.mainactivity.databinding.ActivityNewBinding
import com.example.mainactivity.databinding.ActivityTestBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.text.NumberFormat
import java.util.HashMap

class TestActivity : AppCompatActivity() {
    private  var binding: ActivityTestBinding? =null
    val fireStoreDatabase= FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //設定隱藏標題
        getSupportActionBar()?.hide();
        val Next = findViewById<ImageButton>(R.id.Next)
        //題目
        val content1 = findViewById<TextView>(R.id.content1)
        val textViewString = content1.text.toString()
        val t0=findViewById<RadioGroup>(R.id.t0)
        content1.text = " 睡眠困難，譬如難以入睡、易醒或早醒"


        Next.setOnClickListener {
            //存取外部資料庫
            var zero: String =binding!!.zero.text.toString()
            var one: String =binding!!.one.text.toString()
            val Testrecord:MutableMap<String,Any> = HashMap()
            Testrecord["zero"]=zero
            Testrecord["one"]=one
            fireStoreDatabase.collection("Testrecord")
                .add(Testrecord)
                .addOnSuccessListener {
                    Log.d(TAG,"Added document with Id ${it.id}")
                }
                .addOnFailureListener {
                    Log.w(TAG,"Error adding document ${it}")
                }
            finish()

            /*val b = Bundle()
            b.putInt("t0",0)
            b.putInt("one",1)
            b.putInt("two",2)
            b.putInt("three",3)
            b.putInt("four",4)
            b.putInt("five",5)

            val it = Intent(this, TestActivity2::class.java)
            intent.putExtras(b)
            startActivity(it)*/
        }
    }
}



/*
            b.putExtras("one",1)
            b.putExtras("two",2)
            b.putExtras("three",3)
            b.putExtras("four",4)
            b.putExtras("five",5)

            private fun Bundle.putExtras(s: String, i: Int) {

}

private fun Intent.putExtras(s: String, i: Int) {

}*/