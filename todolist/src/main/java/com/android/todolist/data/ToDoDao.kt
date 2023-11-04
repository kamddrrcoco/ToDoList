package com.android.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): List<ToDoData>

    @Query("SELECT * FROM todo_table where id=(:id)")
    fun selectFromId(id: Int): ToDoData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(toDoData: ToDoData)

    @Update
    fun update(toDoData: ToDoData)

    @Delete
    fun delete(vararg toDoData: ToDoData)

    @Query("DELETE FROM todo_table")
    fun deleteAll()
}