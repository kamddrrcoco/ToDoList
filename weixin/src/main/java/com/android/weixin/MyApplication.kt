package com.android.weixin

import android.app.Application
import com.android.weixin.data.ChatDao
import com.android.weixin.data.ChatDatabase

class MyApplication:Application() {
    companion object {
        var chatDao: ChatDao? = null
    }

    override fun onCreate() {
        super.onCreate()
        chatDao = ChatDatabase.create(this).chatDao()
    }
}