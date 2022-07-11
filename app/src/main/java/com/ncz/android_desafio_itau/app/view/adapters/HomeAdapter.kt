package com.ncz.android_desafio_itau.app.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.ReleaseCardBinding
import com.ncz.android_desafio_itau.domain.entities.Release
import com.ncz.android_desafio_itau.domain.utils.extensions.OnClick
import com.ncz.android_desafio_itau.domain.utils.states.toCurrencyFormat

class HomeAdapter(val release: List<Release> = listOf()) :
    RecyclerView.Adapter<HomeAdapter.ReleaseViewHolder>() {

    private lateinit var onClick: OnClick

    val newReleases by lazy {
        ArrayList<Release>(release.size).apply {
            addAll(release)
        }
    }


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
        holder.originName.text = newReleases[position].origem
        holder.value.text = newReleases[position].valor.toCurrencyFormat()
        holder.category.text = newReleases[position].categoria?.nome.toString()
        release[position].categoria

        val item = holder.itemView
        item.setOnClickListener {
            onClick.onCellClickListener(newReleases[position])
        }
    }

    override fun getItemCount() = newReleases.size

    fun onClickListener(onClick: OnClick) {
        this.onClick = onClick
    }

    fun doFilter(months: List<Int>?, categories: List<Int>?) {
        newReleases.clear()

        val filter = release.filter { release ->
            val foundCategoria =
                if (categories?.isEmpty() != false) true else categories.any { it == release.categoria?.id }
            val foundMonths =
                if (months?.isEmpty() != false) true else months.any { it == release.mesLancamento }

            foundMonths ?: true && foundCategoria ?: true
        }

        newReleases.addAll(filter)
        notifyDataSetChanged()
    }
}

