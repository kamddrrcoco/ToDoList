package com.android.mytest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityData::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): Dao?
}