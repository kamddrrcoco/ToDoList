package com.android.todolist

import android.app.Application
import com.android.todolist.data.ToDoDao
import com.android.todolist.data.ToDoDatabase

class App : Application() {
    var toDoDao: ToDoDao? = null
    override fun onCreate() {
        super.onCreate()
        toDoDao = ToDoDatabase.getDatabase(this).toDoDao()
    }
}