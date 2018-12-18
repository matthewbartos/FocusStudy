package com.matthewbartos.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        const val TAG = "HomeFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        square_1.setOnClickListener { Toast.makeText(context, "Square 1", Toast.LENGTH_SHORT).show() }
        square_2.setOnClickListener { Toast.makeText(context, "Square 2", Toast.LENGTH_SHORT).show() }
        square_3.setOnClickListener { Toast.makeText(context, "Square 3", Toast.LENGTH_SHORT).show() }
        square_4.setOnClickListener { Toast.makeText(context, "Square 4", Toast.LENGTH_SHORT).show() }
        square_5.setOnClickListener { Toast.makeText(context, "Square 5", Toast.LENGTH_SHORT).show() }
    }
}
