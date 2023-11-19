package com.android.mytest

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_register).setOnClickListener {
            startActivityForResult(Intent(this@MainActivity, AddActivity::class.java), 1)

        }
        findViewById<Button>(R.id.btn_set).setOnClickListener {
            startActivity(Intent(this@MainActivity, Activity::class.java))
        }

        findViewById<Button>(R.id.btn_delete).setOnClickListener {
            val builder: AlertDialog.Builder? = it?.let {
                AlertDialog.Builder(this)
            }
            builder?.setTitle("删除数据")
                ?.setMessage("确认要删除吗？")
            builder?.apply {
                setPositiveButton("确认") { _, _ ->
                    Toast.makeText(context, "删除", Toast.LENGTH_LONG).show()
                }
                setNegativeButton("取消") { _, _ ->
                    Toast.makeText(context, "取消", Toast.LENGTH_LONG).show()
                }
            }
            builder?.show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 2) {
            val name = data?.getStringExtra("name")
            val password = data?.getStringExtra("password")
            findViewById<EditText>(R.id.ed_text1).setText(name)
            findViewById<EditText>(R.id.ed_password1)?.setText(password)
        }
    }
}
