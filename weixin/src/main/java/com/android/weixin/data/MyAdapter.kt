package com.android.weixin.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.weixin.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    private var chatList = emptyList<ChatEntity>()

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imIcon: ImageView
        val tvName: TextView
        val tvContent: TextView

        init {
            imIcon = view.findViewById(R.id.iv_chat_icon)
            tvName = view.findViewById(R.id.tv_chat_name)
            tvContent = view.findViewById(R.id.tv_chat_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_chat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvName.text = chatList[position].name
        holder.tvContent.text = chatList[position].content
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}