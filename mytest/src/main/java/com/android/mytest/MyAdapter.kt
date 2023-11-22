package com.android.mytest

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MyAdapter(layoutRes: Int = R.layout.item_recyclerview) :
    BaseQuickAdapter<ItemData, BaseViewHolder>(layoutRes) {
    override fun convert(holder: BaseViewHolder, item: ItemData) {
        holder.getView<TextView>(R.id.tv_title).text = item.title
        holder.getView<TextView>(R.id.tv_content).text = item.content
    }

}