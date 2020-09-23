package com.testing.kotlinapplication.ui.detailproduct

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.google.android.material.appbar.AppBarLayout
import com.testing.kotlinapplication.MainActivity

import com.testing.kotlinapplication.R
import kotlinx.android.synthetic.main.fragment_detail_product.*

/**
 * A simple [Fragment] subclass.
 */
class DetailProductFragment : Fragment() {

    private val args: DetailProductFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener({ v -> activity?.onBackPressed() })
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var titleIsShowing = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsing_toolbar.title = "New Omega"
                    titleIsShowing = true
                } else if (titleIsShowing) {
                    collapsing_toolbar.title =
                        " "//careful there should a space between double quote otherwise it wont work
                    titleIsShowing = false
                }
            }

        })
        (activity as MainActivity).setActionBar(toolbar)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).hideAppBar()
        (activity as MainActivity).hideBottomNavigation()
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).showAppBar()
        (activity as MainActivity).resetActionBar()
        if (args.turn == 1) {
            (activity as MainActivity).showBottomNavigation()
        }
    }

}

