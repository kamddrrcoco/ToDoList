package com.android.weixin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat_data ")
    fun getAllData(): List<ChatEntity>

    @Delete
    fun delete(vararg chatEntity: ChatEntity)

    @Insert
    fun insertData(chatEntity: ChatEntity)
}