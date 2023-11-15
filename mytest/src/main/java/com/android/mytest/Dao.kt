package com.android.mytest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertAll(data: EntityData?)

    @get:Query("SELECT * FROM entitydata")
    val all: List<EntityData?>?
}