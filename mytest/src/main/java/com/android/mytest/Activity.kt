package com.android.mytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.android.mytest.fragment.Fragment1
import com.android.mytest.fragment.Fragment2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)

        val tabLayout = findViewById<TabLayout>(R.id.tl_tab)
        val viewPager = findViewById<ViewPager2>(R.id.vp_view)

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 2     //告诉ViewPager有几个页面
            override fun createFragment(position: Int) =     //给页面指定位置
                when (position) {
                    0 -> Fragment1()
                    else -> Fragment2()
                }
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->      //把tabLayout和viewpager放进去，再写一个标题
            when (position) {
                0 -> tab.text = "第一个页面"
                else -> tab.text = "第二个页面"
            }
        }.attach()
    }
}