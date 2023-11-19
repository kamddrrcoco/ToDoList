package com.android.weixin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.android.weixin.data.ChatEntity
import com.android.weixin.fragment.AddressBookFragment
import com.android.weixin.fragment.ChatFragment
import com.android.weixin.fragment.MeFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tl_tab)
        val viewPager = findViewById<ViewPager2>(R.id.vp_content)

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 3    //告诉ViewPager有几个页面
            override fun createFragment(position: Int) =     //给页面指定位置
                when (position) {
                    0 -> ChatFragment()
                    1 -> AddressBookFragment()
                    else -> MeFragment()
                }
        }
        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->      //把tabLayout和viewpager放进去，再写一个标题
            when (position) {
                0 -> tab.text = "聊天"
                1 -> tab.text = "通讯录"
                else -> tab.text = "我"
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val s=(1..10000).random()
        val name="$s"
        when (item.itemId) {
            R.id.menu_add -> {
                MyApplication.chatDao?.insertData(ChatEntity(0, name))
            }
        }
        return super.onOptionsItemSelected(item)
    }

}