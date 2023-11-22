package com.android.mytest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.mytest.ItemData
import com.android.mytest.MyAdapter
import com.android.mytest.R

class Fragment1 : Fragment() {
    private val adapter = MyAdapter()
    private val list: ArrayList<ItemData>? = null
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager=layoutManager
        list?.add(ItemData(0,"1号标题","1号内容"))
        list?.add(ItemData(1,"2号标题","2号内容"))
        list?.add(ItemData(2,"3号标题","3号内容"))
        return recyclerView
    }
    override fun onResume() {
        super.onResume()

    }
}