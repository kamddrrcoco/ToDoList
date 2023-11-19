package com.android.todolist

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        val layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        adapter.setChange {
            val builder: AlertDialog.Builder = it.let {
                AlertDialog.Builder(this)
            }
            builder.setTitle("删除数据")
                ?.setMessage("确认要删除吗？")
            builder.apply {
                setPositiveButton("确认") { _, _ ->
                    MyApplication.toDoDao?.delete(it)
                    updateUI()
                }
                setNegativeButton("取消") { _, _ ->
                    Toast.makeText(context, "取消", Toast.LENGTH_LONG).show()
                }
            }
            builder.show()
        }
        adapter.setOnItemClickListener { _, _, position ->
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