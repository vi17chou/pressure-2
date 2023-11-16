package com.example.mainactivity

import android.accounts.Account
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.jar.Attributes.Name


class backstage_USER : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_user)
        // 初始化 Adapter
        adapter = UserAdapter(emptyList())

        val backhome=findViewById<Button>(R.id.backhome5)
        val recyclerView=findViewById<RecyclerView>(R.id.user_list)
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
        val collectionRef = fireStoreDatabase.collection("Users")

        // 執行查詢
        collectionRef
            .get()
            .addOnSuccessListener { result ->
                // 在這裡處理查詢成功的結果
                val data = ArrayList<String>()

                for (document in result) {
                    // 取得文件中的資料
                    val Account = document.getString("Account")
                    val Password = document.getString("Password")
                    val Name = document.getString("Name")
                    val Gender = document.getString("Gender")
                    val Birthday = document.getString("Birthday")


                    val test1Value = Account?: ""
                    val test2Value = Password?: ""
                    val test3Value = Name?: ""
                    val test4Value = Gender?: ""
                    val test5Value = Birthday?: ""

                    val rowData = "帳號:$test1Value\n密碼:$test2Value\n姓名:$test3Value\n性別:$test4Value\n生日:$test5Value"
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