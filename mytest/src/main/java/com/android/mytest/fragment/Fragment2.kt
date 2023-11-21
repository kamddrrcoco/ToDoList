package com.android.mytest.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.android.mytest.R

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_2, container, false)
        view.findViewById<ImageButton>(R.id.btn_set).setOnClickListener{ startActivityForResult(
            Intent(Intent.ACTION_PICK).setType("image/*"), 15
        )}
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val image=view?.findViewById<ImageButton>(R.id.btn_set)
        if (15 == requestCode) {
            val uri = data!!.data
            image?.setImageURI(uri)
        }
    }
}