package com.ncz.android_desafio_itau.app.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncz.android_desafio_itau.databinding.HomeFilterByMonthCardBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFilterMonthsAdapter() : RecyclerView.Adapter<HomeFilterMonthsAdapter.HomeFilterMonthsHolder>() {
    @SuppressLint("SimpleDateFormat")
    private final val simpleDateFormat = SimpleDateFormat("MMMM")

    private val monthsSelected = arrayListOf(false, false, false,false, false, false, false, false, false, false, false, false)

    inner class HomeFilterMonthsHolder(val binding: HomeFilterByMonthCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFilterMonthsHolder {
        val binding = HomeFilterByMonthCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeFilterMonthsHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeFilterMonthsHolder, position: Int) {
        holder.binding.monthNumber.text = "${position + 1}".padStart(2, '0')

        val date = GregorianCalendar()
        date.set(Calendar.MONTH, position)
        holder.binding.monthText.text = simpleDateFormat.format(date.time).uppercase(Locale.getDefault())

        holder.binding.monthCard.isCheckable = monthsSelected[position]
        holder.binding.monthText.isEnabled = monthsSelected[position]
        holder.binding.monthNumber.isEnabled = monthsSelected[position]


        holder.itemView.setOnClickListener {
            for (i in 0 until monthsSelected.size) {
                monthsSelected[i] = false
            }
            monthsSelected[position] = !monthsSelected[position]
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = 12

    fun getMonthsSelected() = monthsSelected.mapIndexedNotNull { index, b -> if(b) index else null}
}