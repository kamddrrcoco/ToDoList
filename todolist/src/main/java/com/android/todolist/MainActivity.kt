package com.android.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment1))
    }

    override fun onSupportNavigateUp(): Boolean {   //支持向上导航，添加一个返回键
        val navController = findNavController(R.id.fragment1)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}