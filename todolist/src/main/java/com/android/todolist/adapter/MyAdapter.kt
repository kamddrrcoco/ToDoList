package com.android.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.todolist.data.ToDoData
import com.android.todolist.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var dataList = emptyList<ToDoData>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent: TextView

        init {
            tvContent = itemView.findViewById(R.id.tv_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvContent.text = dataList[position].content
    }
}
