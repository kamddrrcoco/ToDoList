package com.android.weixin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.android.weixin.fragment.AddressBookFragment
import com.android.weixin.fragment.ChatFragment
import com.android.weixin.fragment.FindFragment
import com.android.weixin.fragment.MeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_chat).setOnClickListener { onClick(ChatFragment()) }//点击按钮，跳转到指定的fragment
        findViewById<Button>(R.id.btn_address_book).setOnClickListener { onClick(AddressBookFragment()) }
        findViewById<Button>(R.id.btn_find).setOnClickListener { onClick(FindFragment()) }
        findViewById<Button>(R.id.btn_me).setOnClickListener { onClick(MeFragment()) }
    }

    private fun onClick(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.ll_content, fragment!!).commit()
    }
}