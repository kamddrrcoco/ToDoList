package com.android.weixin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.weixin.MyApplication
import com.android.weixin.R
import com.android.weixin.data.ChatEntity
import com.android.weixin.data.ListAdapter

class ChatFragment : Fragment() {
    private val adapter = ListAdapter()
    private var list: List<ChatEntity>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)
     /*   val recyclerView = view.findViewById<RecyclerView>(R.id.rv_chat_view)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        MyApplication.chatDao?.insertData(ChatEntity(0,R.drawable.box,"张三",""))*/
        return view
    }
}
