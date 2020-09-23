package com.testing.kotlinapplication.ui.orderhistory

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.testing.kotlinapplication.MainActivity
import com.testing.kotlinapplication.R
import kotlinx.android.synthetic.main.fragment_order_history.*


class OrderHistoryFragment : Fragment() {

    private lateinit var mAdapter: OrderHistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = context?.let { OrderHistoryAdapter(it, initData()) }!!
        rv_history.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

    }

    fun initData(): ArrayList<String> {
        var list = ArrayList<String>()
        for (i in 0..9) {
            list.add(" ")
        }
        return list
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).hideBottomNavigation()
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).showBottomNavigation()
    }
}