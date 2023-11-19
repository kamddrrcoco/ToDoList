package com.android.weixin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.weixin.MyApplication
import com.android.weixin.R
import com.android.weixin.data.ChatAdapter
import com.android.weixin.data.ChatEntity


class AddressBookFragment : Fragment() {
    private var rvBooK: RecyclerView? = null
    private var adapter = ChatAdapter()
    private val layoutManager = LinearLayoutManager(context)
    private var list: List<ChatEntity>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_address_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvBooK = view.findViewById(R.id.rv_book)
        rvBooK?.adapter = adapter
        rvBooK?.layoutManager = layoutManager
        adapter.setChange {
            MyApplication.chatDao?.delete(it)
            updateUI()
        }
        updateUI()
    }
    private fun updateUI() {
        list = MyApplication.chatDao?.getAllData()!!
        adapter.setNewInstance(list!!.toMutableList())
    }


    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun onClick(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.vp_content, fragment)?.commit()
    }
}