package com.testing.kotlinapplication.ui.help

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.kotlinapplication.R
import com.testing.kotlinapplication.ui.help.model.Item
import kotlinx.android.synthetic.main.row_help.view.*

class ItemAdapter(val mContext: Context, val mList: ArrayList<Item>, val itemClick: HelpItemClick) :
    RecyclerView.Adapter<ItemAdapter.ItemViewholder>() {
    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_name_help = itemView.txt_name_help
        fun bindView(item: Item) {
            txt_name_help.setText(item.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        var itemView =
            LayoutInflater.from(mContext).inflate(R.layout.row_help, parent, false) as View
        return ItemViewholder(itemView)
    }

    override fun getItemCount(): Int {
        if (mList == null) {
            return 0
        } else {
            return mList.size
        }
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bindView(mList.get(position))
        holder.itemView.setOnClickListener({ view -> itemClick.onItemClick(position) })
    }
}