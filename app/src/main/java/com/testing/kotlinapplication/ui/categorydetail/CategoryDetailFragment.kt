package com.testing.kotlinapplication.ui.categorydetail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.testing.kotlinapplication.MainActivity

import com.testing.kotlinapplication.R
import com.testing.kotlinapplication.ui.recent.Itemclick
import com.testing.kotlinapplication.ui.recent.ProductAdapter
import kotlinx.android.synthetic.main.fragment_category_detail.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryDetailFragment : Fragment(), Itemclick {
    private lateinit var mList: ArrayList<String>
    private lateinit var mAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initData()
        return inflater.inflate(R.layout.fragment_category_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_category_detail.apply {
            adapter = mAdapter
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(view.context, 2)
        }
    }

    private fun initData() {
        mList = ArrayList()
        for (i in 0..15) {
            mList.add(" ")
        }
        mAdapter = context?.let { ProductAdapter(mList, it, this) }!!
    }

    override fun onItemClick() {
        val action =
            CategoryDetailFragmentDirections.actionCategoryDetailFragmentToDetailProductFragment(0,0)
        findNavController().navigate(action)
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
