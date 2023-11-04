package com.android.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null
        fun create(context: Context): ToDoDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToDoDatabase::class.java,
                "todo_database.db"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}