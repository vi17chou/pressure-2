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


class backstage_USER : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backstage_user)
        // 初始化 Adapter
        adapter = UserAdapter(emptyList())

        val backhome=findViewById<Button>(R.id.backhome)
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
                    val Birthday = document.getString("Birthday")
                    val Gender = document.getString("Gender")
                    val Name = document.getString("Name")
                    val Password = document.getString("Password")
                    val ConfirmPassword = document.getString("ConfirmPassword")

                    val test1Value = Name?: ""
                    val test2Value = Birthday?: ""
                    val test3Value = Gender?: ""
                    val test4Value = Account?: ""
                    val test5Value = Password?: ""
                    val test6Value = ConfirmPassword?: ""

                    val rowData = "姓名$test1Value,生日 $test2Value,性別 $test3Value,帳號 $test4Value,密碼 $test5Value,確認密碼 $test6Value"
                    data.add(rowData)
                    Log.d("FirestoreData", "Document: $rowData")
                }
                Log.d("FirestoreData", "Number of documents: ${result.size()}")
                // 更新 Adapter 的資料
                adapter.updateData(data)

            }
            .addOnFailureListener { exception ->
                // 處理查詢失敗的情況
                Log.e("FirestoreData", "Error getting documents", exception)
            }
    }
}