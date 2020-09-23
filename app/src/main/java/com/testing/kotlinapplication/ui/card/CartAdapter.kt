package com.testing.kotlinapplication.ui.card

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.kotlinapplication.R

class CartAdapter(val mContext: Context, var mList: ArrayList<String>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.row_card, parent, false)
        return CartViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (mList == null) {
            return 0
        } else {
            return mList.size
        }
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bindView();
    }

}