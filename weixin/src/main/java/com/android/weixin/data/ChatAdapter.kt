package com.android.weixin.data

import android.widget.Button
import android.widget.TextView
import com.android.weixin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ChatAdapter(layout: Int = R.layout.item_list_book) :
    BaseQuickAdapter<ChatEntity, BaseViewHolder>(layout) {
    override fun convert(holder: BaseViewHolder, item: ChatEntity) {
        holder.getView<TextView>(R.id.tv_book_name).text = item.name
        holder.getView<Button>(R.id.delete).setOnClickListener {
            onCheckBoxChangeListener?.onchange(item)
        }
    }

    fun setChange(change: (ChatEntity) -> Unit) {
        onCheckBoxChangeListener = object : OnCheckBoxChangeListener {
            override fun onchange(item: ChatEntity) = change(item)
        }
    }

    private var onCheckBoxChangeListener: OnCheckBoxChangeListener? = null

    interface OnCheckBoxChangeListener {
        fun onchange(item: ChatEntity)
    }

}