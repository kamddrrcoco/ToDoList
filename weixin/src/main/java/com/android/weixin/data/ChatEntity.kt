package com.android.weixin.data

import android.graphics.drawable.Icon
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "chat_data")
 class ChatEntity(
  @PrimaryKey(autoGenerate = true)  val id:Int,
    val name: String
)