package com.android.todolist.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.android.todolist.MyApplication
import com.android.todolist.R
import com.android.todolist.data.ToDoData


class AddFragment : Fragment() {
    private var tvTitle: EditText? = null
    private var tvContent: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.activity_edit, container, false)
        tvTitle = view.findViewById(R.id.ed_title_text)
        tvContent = view.findViewById(R.id.ed_content_text)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> {
                val strTitle = tvTitle?.text.toString()
                val strContent = tvContent?.text.toString()
                if (!TextUtils.isEmpty(strTitle)) {
                    if (!TextUtils.isEmpty(strContent)) {
                        MyApplication.toDoDao?.insertData(ToDoData(0, strTitle, strContent))
                    } else {
                        tvContent?.requestFocus()
                        tvContent?.error = "请输入内容"
                    }
                } else {
                    tvTitle?.requestFocus()
                    tvTitle?.error = "请输入标题"
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}