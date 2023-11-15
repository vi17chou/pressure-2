package com.example.mainactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TestAdapter (private var dataList: List<String>) :
    RecyclerView.Adapter<TestAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.test_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newData: List<String>) {
        dataList = newData
        notifyDataSetChanged()
    }
}
