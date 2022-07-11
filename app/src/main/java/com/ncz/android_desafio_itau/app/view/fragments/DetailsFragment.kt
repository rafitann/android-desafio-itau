package com.ncz.android_desafio_itau.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ncz.android_desafio_itau.R
import com.ncz.android_desafio_itau.databinding.FragmentDetailsBinding
import com.ncz.android_desafio_itau.domain.utils.states.toCurrencyFormat

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        getDetail()
        binding.includeToolbar.toolbar.setOnClickListener {findNavController().popBackStack()}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDetail() {
        binding.origin.text = args.releaseObject.origem
        binding.value.text = args.releaseObject.valor.toCurrencyFormat()
        binding.category.text = args.releaseObject.categoria?.nome.toString()
    }


    private fun setupToolbar() {
        binding.includeToolbar.toolbar.title = getString(R.string.details)
    }


}