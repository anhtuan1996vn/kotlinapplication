package com.testing.kotlinapplication.ui.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.testing.kotlinapplication.R
import com.testing.kotlinapplication.ui.category.model.Category
import kotlinx.android.synthetic.main.fragment_category.*

/**
 * A simple [Fragment] subclass.
 */
class CategoryFragment : Fragment(), CategoryAdapter.CategoryItemClick {

    private lateinit var mAdapter: CategoryAdapter
    private lateinit var mListCategory: ArrayList<Category>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_category, container, false) as View
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        mapping(view)
        rv_category.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun mapping(view: View) {
        mAdapter = CategoryAdapter(view.context, mListCategory,this)
    }

    private fun initData() {
        mListCategory = ArrayList()
        mListCategory.add(Category("Health & Sport", R.drawable.ic_american_football, 30, 5))
        mListCategory.add(Category("Electronics & Gadgets", R.drawable.ic_computer, 32, 5))
        mListCategory.add(Category("Fashions", R.drawable.ic_eye_makeup, 34, 4))
        mListCategory.add(Category("Baby Gear", R.drawable.ic_baby, 36, 5))
        mListCategory.add(Category("Home & Furnitrue", R.drawable.ic_real_estate, 38, 5))
        mListCategory.add(Category("Office & Industry", R.drawable.ic_printer, 40, 5))
    }

    override fun onItemClick(category: Category) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToCategoryDetailFragment()
        findNavController().navigate(action)
    }


}
