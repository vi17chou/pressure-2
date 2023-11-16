package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


val fireStoreDatabase= FirebaseFirestore.getInstance()
class backstage_test : AppCompatActivity() {
    private lateinit var adapter: TestAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_test)
        // 初始化 Adapter
        adapter = TestAdapter(emptyList())

        val backhome = findViewById<Button>(R.id.backhome5)
        val test_result = findViewById<Button>(R.id.test_result)
        var recyclerView = findViewById<RecyclerView>(R.id.test_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter  // 設定 adapter 給 RecyclerView

        // 讀取資料並更新 Adapter
        readDataFromFirestore()

        test_result.setOnClickListener {
            val it= Intent(this,backstage_DietFood::class.java)
            startActivity(it)
        }

        backhome.setOnClickListener {
            val it= Intent(this,backstage_main::class.java)
            startActivity(it)
        }
    }
    private fun readDataFromFirestore() {
        // 取得 Firestore 中的集合
        val collectionRef = fireStoreDatabase.collection("Test")

        // 執行查詢
        collectionRef
            .get()
            .addOnSuccessListener { result ->
                // 在這裡處理查詢成功的結果
                val data = ArrayList<String>()

                for (document in result) {
                    // 取得文件中的資料
                    val SCORE10 = document.getLong("前十題總分")
                    val SCORE11 = document.getLong("第十一題分數")
                    val test_today = document.getString("test_today")

                    val test1Value = SCORE10?.toString() ?: ""
                    val test2Value = SCORE11?.toString() ?: ""
                    val test3Value = test_today?: ""

                    val rowData = "$test3Value,\n前十題總分$test1Value,\n第十一題分數 $test2Value"
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