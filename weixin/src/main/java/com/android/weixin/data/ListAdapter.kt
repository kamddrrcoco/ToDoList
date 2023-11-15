package com.android.weixin.data

import android.widget.ImageView
import android.widget.TextView
import com.android.weixin.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder


class ListAdapter(layoutRes: Int = R.layout.item_list_book) :
    BaseQuickAdapter<ChatEntity, BaseViewHolder>(layoutRes) {

    override fun convert(holder: BaseViewHolder, item: ChatEntity) {
        holder.getView<ImageView>(R.id.iv_book_icon).imageAlpha=item.icon
        holder.getView<TextView>(R.id.tv_book_name).text=item.name
    }
}