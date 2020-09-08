package com.example.chuck.categorieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chuck.R
import kotlinx.android.synthetic.main.item_category_row.view.*

class CategoriesAdapter(private val categoriesList: List<String>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewHolder {

        val rowView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_row, parent, false)
        return CategoriesViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        holder.update(categoriesList[position])
    }

    override fun getItemCount(): Int = categoriesList.size

    class CategoriesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun update(category: String) {
            view.category_title.text = category
            view.setOnClickListener { }
        }
    }
}