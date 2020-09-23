package com.testing.kotlinapplication.ui.detailhelp

import android.content.Context
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.testing.kotlinapplication.MainActivity

import com.testing.kotlinapplication.R
import kotlinx.android.synthetic.main.fragment_detail_help.*

/**
 * A simple [Fragment] subclass.
 */
class DetailHelpFragment : Fragment() {

    val args: DetailHelpFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = args.type
        var id=0
        var title=""
        when (data) {
            0 -> {
                id = R.string.html_0
                title = "How to order"
            }
            1 -> {
                id = R.string.html_1
                title = "Payment"
            }
            2 -> {
                id = R.string.html_2
                title = "Shipping"
            }
            3 -> {
                id = R.string.html_3
                title = "Profile"
            }
            4 -> {
                id = R.string.html_4
                title = "Contact Us"
            }
        }
        val htmlResource = Html.fromHtml(getString(id), 1)
        txtview.setText(htmlResource)
        (activity as MainActivity).setTitle(title)
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
