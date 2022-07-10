package com.ncz.android_desafio_itau.app.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.ReleaseCardBinding
import com.ncz.android_desafio_itau.domain.model.Release

class HomeAdapter(val release: List<Release> = listOf()) : RecyclerView.Adapter<HomeAdapter.ReleaseViewHolder>() {

    inner class ReleaseViewHolder(binding: ReleaseCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val originName = binding.originName
        val value = binding.value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleaseViewHolder {
        val binding = ReleaseCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReleaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ReleaseViewHolder, position: Int) {
        holder.originName.text = release[position].origem
        holder.value.text = release[position].valor.toString()
        release[position].categoria
    }

    override fun getItemCount() = release.size
}
