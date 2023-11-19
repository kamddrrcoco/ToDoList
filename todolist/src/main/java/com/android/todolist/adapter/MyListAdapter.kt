package com.android.todolist.adapter

import android.widget.Button
import android.widget.TextView
import com.android.todolist.R
import com.android.todolist.data.ToDoData
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MyListAdapter(layoutRes: Int = R.layout.item_view) :
    BaseQuickAdapter<ToDoData, BaseViewHolder>(layoutRes) {
    override fun convert(holder: BaseViewHolder, item: ToDoData) {
        holder.getView<TextView>(R.id.tv_title).text = item.title
        holder.getView<TextView>(R.id.tv_content).text = item.content
        holder.getView<Button>(R.id.delete).setOnClickListener {
            onCheckBoxChangeListener?.onchange(item)
        }
    }

    fun setChange(change: (ToDoData) -> Unit) {
        onCheckBoxChangeListener = object : OnCheckBoxChangeListener {
            override fun onchange(item: ToDoData) = change(item)
        }
    }

    private var onCheckBoxChangeListener: OnCheckBoxChangeListener? = null

    interface OnCheckBoxChangeListener {
        fun onchange(item: ToDoData)
    }
}