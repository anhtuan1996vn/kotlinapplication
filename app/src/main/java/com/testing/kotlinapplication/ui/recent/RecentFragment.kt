package com.testing.kotlinapplication.ui.recent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.testing.kotlinapplication.R

/**
 * A simple [Fragment] subclass.
 */
class RecentFragment : Fragment(), Itemclick {

    private lateinit var rv_top: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var mList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_recent, container, false) as View
        mapping(view)
        return view
    }

    fun mapping(view: View) {
        rv_top = view.findViewById(R.id.rv_top)
        mList = ArrayList()
        for (i in 0..9) {
            mList.add("new omega");
        }
        productAdapter = ProductAdapter(mList, view.context, this)
        rv_top.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = productAdapter
        }
    }

    override fun onItemClick() {

        val action = RecentFragmentDirections.actionRecentFragmentToDetailProductFragment(1,3)
        findNavController().navigate(action)
    }

}
