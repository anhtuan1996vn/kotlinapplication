package com.testing.kotlinapplication.ui.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testing.kotlinapplication.R
import com.testing.kotlinapplication.ui.category.model.Category
import kotlinx.android.synthetic.main.row_category.view.*

class CategoryAdapter(
    val mContext: Context,
    val mList: ArrayList<Category>,
    val categoryItemClick: CategoryItemClick
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_category = itemView.txt_category
        var txt_total = itemView.txt_number
        var imageView = itemView.imageView

        fun bindView(item: Category) {
            txt_category.setText(item.name)
            txt_total.setText("${item.total} item(s)")
            imageView.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var itemView =
            LayoutInflater.from(mContext).inflate(R.layout.row_category, parent, false) as View
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (mList == null) {
            return 0
        } else {
            return mList.size;
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindView(mList.get(position))
        holder.itemView.setOnClickListener({ v -> categoryItemClick.onItemClick(mList.get(position)) })
    }

    interface CategoryItemClick {
        fun onItemClick(category: Category)
    }
}