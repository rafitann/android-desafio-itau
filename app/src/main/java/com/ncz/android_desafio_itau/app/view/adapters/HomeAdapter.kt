package com.ncz.android_desafio_itau.app.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.ReleaseCardBinding
import com.ncz.android_desafio_itau.domain.model.Release
import com.ncz.android_desafio_itau.domain.utils.states.OnClick
import com.ncz.android_desafio_itau.domain.utils.states.toCurrencyFormat

class HomeAdapter(val release: List<Release> = listOf()) : RecyclerView.Adapter<HomeAdapter.ReleaseViewHolder>() {

    private lateinit var onClick: OnClick


    inner class ReleaseViewHolder(binding: ReleaseCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val originName = binding.originName
        val value = binding.value
        val category = binding.category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleaseViewHolder {
        val binding = ReleaseCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReleaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ReleaseViewHolder, position: Int) {
        holder.originName.text = release[position].origem
        holder.value.text = release[position].valor.toCurrencyFormat()
        holder.category.text = release[position].categoria?.nome.toString()
        release[position].categoria

        val item = holder.itemView
        item.setOnClickListener{
            onClick.onCellClickListener(release[position])
        }
    }

    override fun getItemCount() = release.size

    fun onClickListener(onClick: OnClick){
        this.onClick = onClick

    }
}

