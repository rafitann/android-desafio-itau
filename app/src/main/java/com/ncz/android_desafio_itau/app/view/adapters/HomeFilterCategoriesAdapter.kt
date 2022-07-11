package com.ncz.android_desafio_itau.app.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.HomeFilterByCategoryCardBinding
import com.ncz.android_desafio_itau.domain.entities.Category

class HomeFilterCategoriesAdapter(private val categories: List<Category>) : RecyclerView.Adapter<HomeFilterCategoriesAdapter.HomeFilterCategoriesHolder>() {

    private val categoriesSelected by lazy {
        categories.map { false }.toTypedArray()
    }

    inner class HomeFilterCategoriesHolder(val binding: HomeFilterByCategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFilterCategoriesHolder {
        val binding = HomeFilterByCategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeFilterCategoriesHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeFilterCategoriesHolder, position: Int) {
        holder.binding.categoryText.text = categories[position].nome

        holder.binding.categoryCard.isCheckable = categoriesSelected[position]
        holder.binding.categoryText.isEnabled = categoriesSelected[position]

        holder.itemView.setOnClickListener {
            categoriesSelected[position] = !categoriesSelected[position]
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = categories.size

    fun getCategoriesSelected() = categoriesSelected.mapIndexedNotNull { index, b -> if(b) categories[index].id else null }
}