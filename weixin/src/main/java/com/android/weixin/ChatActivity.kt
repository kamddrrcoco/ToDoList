package com.android.weixin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        onClick(ChatViewFragment())
    }

    private fun onClick(fragment: Fragment) {
        supportFragmentManager.beginTransaction()?.replace(R.id.ll_chat_view, fragment)?.commit()
    }
}