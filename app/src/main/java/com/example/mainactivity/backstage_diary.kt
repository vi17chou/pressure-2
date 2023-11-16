package com.example.mainactivity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class backstage_diary : AppCompatActivity() {
    private lateinit var adapter: DiaryAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_diary)
        // 初始化 Adapter
        adapter = DiaryAdapter(emptyList())

        val backhome=findViewById<Button>(R.id.backhome)
        val recyclerView=findViewById<RecyclerView>(R.id.diary_list)
        recyclerView.layoutManager = LinearLayoutManager(this)


        recyclerView.adapter = adapter  // 設定 adapter 給 RecyclerView

        // 讀取資料並更新 Adapter
        readDataFromFirestore()

        backhome.setOnClickListener {
            val it= Intent(this,backstage_main::class.java)
            startActivity(it)
        }
    }
    private fun readDataFromFirestore() {
        // 取得 Firestore 中的集合
        val collectionRef = fireStoreDatabase.collection("Diary")

        // 執行查詢
        collectionRef
            .get()
            .addOnSuccessListener { result ->
                // 在這裡處理查詢成功的結果
                val data = ArrayList<String>()

                for (document in result) {
                    // 取得文件中的資料
                    val Today = document.getString("Today")
                    val newdiary = document.getString("newdiary")

                    val test1Value = Today?: ""
                    val test2Value = newdiary?: ""

                    val rowData = "$test1Value\n$test2Value"
                    data.add(rowData)
                    Log.d("FirestoreData", "Document: $rowData")
                }
                //Log.d("FirestoreData", "Number of documents: ${result.size()}")
                // 更新 Adapter 的資料
                adapter.updateData(data)

            }
            .addOnFailureListener { exception ->
                // 處理查詢失敗的情況
                Log.e("FirestoreData", "Error getting documents", exception)
            }
    }
}