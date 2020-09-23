package com.testing.kotlinapplication.ui.orderhistory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.kotlinapplication.R

class OrderHistoryAdapter(private var mContext: Context, private var mList: ArrayList<String>) :
    RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder>() {
    class OrderHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(data: String) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.item_history, parent, false)
        return OrderHistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (mList == null) {
            return 0
        } else {
            return mList.size
        }
    }

    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {
        holder.bindView(mList.get(position))
    }

}