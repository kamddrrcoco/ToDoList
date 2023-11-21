package com.android.todolist.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.android.todolist.MainActivity
import com.android.todolist.MyApplication
import com.android.todolist.R
import com.android.todolist.data.ToDoData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditActivity : AppCompatActivity() {
    private var etTitle: EditText? = null
    private var etContent: EditText? = null
    private var mId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        etTitle = findViewById(R.id.ed_title)
        etContent = findViewById(R.id.ed_content)
        val id = intent.getIntExtra("id", -1)
        val toDoData = MyApplication.toDoDao?.selectFromId(id)
        toDoData?.apply {
            mId = id
            etTitle?.setText(title)
            etContent?.setText(content)
        }
        findViewById<Button>(R.id.btn_complete).setOnClickListener {
            val strTitle = etTitle?.text.toString()
            val strContent = etContent?.text.toString()
            if (!TextUtils.isEmpty(strTitle)) {
                if (!TextUtils.isEmpty(strContent)) {
                    MyApplication.toDoDao?.insertData(ToDoData(mId, strTitle, strContent))
                    finish()
                } else {
                    etContent?.requestFocus()
                    etContent?.error = "请输入内容"
                }
            } else {
                etTitle?.requestFocus()
                etTitle?.error = "请输入标题"
            }
        }
        findViewById<Button>(R.id.btn_return).setOnClickListener {
            finish()
        }
    }
}