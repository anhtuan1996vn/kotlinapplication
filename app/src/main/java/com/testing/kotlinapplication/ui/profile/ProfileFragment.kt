package com.testing.kotlinapplication.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.testing.kotlinapplication.MainActivity

import com.testing.kotlinapplication.R
import com.testing.kotlinapplication.ui.authencation.AuthencationActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.Dispatchers.Main

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false) as View
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ll_history.setOnClickListener({ v ->
            doNavigateToHistory()
        })
        btn_edit.setOnClickListener {
            activity?.let {
                val intent = Intent(it, AuthencationActivity::class.java)
                it.startActivity(intent)
            }
        }
    }

    fun doNavigateToHistory() {
        var action = ProfileFragmentDirections.actionProfileFragmentToOrderHistoryFragment()
        findNavController().navigate(action)
    }


}
