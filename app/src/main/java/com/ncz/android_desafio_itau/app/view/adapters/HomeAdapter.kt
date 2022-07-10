package com.ncz.android_desafio_itau.app.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.ReleaseCardBinding
import com.ncz.android_desafio_itau.domain.model.Release

class HomeAdapter(private val releases: ArrayList<Release> = arrayListOf()) :
    RecyclerView.Adapter<HomeAdapter.ReleaseViewHolder>() {

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
        holder.originName.text = releases[position].origem
        holder.value.text = releases[position].valor.toString()
        releases[position].categoria
    }

    override fun getItemCount() = releases.size
}
