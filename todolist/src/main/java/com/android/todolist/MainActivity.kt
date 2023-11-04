package com.android.todolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.todolist.adapter.MyListAdapter
import com.android.todolist.data.ToDoData
import com.android.todolist.ui.EditActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val adapter = MyListAdapter()
    private var list: List<ToDoData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        adapter.setChange {
            MyApplication.toDoDao?.delete(it)
            updateUI()
        }
        adapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(this@MainActivity, EditActivity::class.java)
            intent.putExtra("id", list?.get(position)?.id ?: -1)
            startActivity(intent)
        }
        findViewById<FloatingActionButton>(R.id.btn_fab).setOnClickListener {
            startActivity(Intent(this, EditActivity::class.java))
        }
        updateUI()
    }

    private fun updateUI() {
        list = MyApplication.toDoDao?.getAllData()!!
        adapter.setNewInstance(list!!.toMutableList())
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }
}