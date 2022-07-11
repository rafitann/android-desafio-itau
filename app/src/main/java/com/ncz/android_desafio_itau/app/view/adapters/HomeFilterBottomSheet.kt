package com.ncz.android_desafio_itau.app.view.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ncz.android_desafio_itau.databinding.DialogFragmentHomeFilterBinding
import com.ncz.android_desafio_itau.domain.entities.Category

class HomeFilterBottomSheet: BottomSheetDialogFragment() {

    private var _binding: DialogFragmentHomeFilterBinding? = null
    private val binding get() = _binding!!
    private val args: HomeFilterBottomSheetArgs by navArgs()

    private val monthsAdapter = HomeFilterMonthsAdapter()
    private var categoriesAdapter: HomeFilterCategoriesAdapter? = null

    object HomeFilterEvent {
        const val doFilter = "doFilter"
        const val doClearFilter = "doClearFilter"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DialogFragmentHomeFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupInterface()
    }

    private fun setupInterface() {
        setupMonths()
        setupCategories(args.categories.toList())
        setupActions()
    }

    private fun setupMonths() {
        binding.monthRecyclerView.adapter = monthsAdapter
    }

    private fun setupCategories(categories: List<Category>) {
        categoriesAdapter = HomeFilterCategoriesAdapter(categories)
        binding.categoryRecyclerView.hasFixedSize()
        binding.categoryRecyclerView.adapter = categoriesAdapter
    }


    private fun setupActions() {
        binding.applyButton.setOnClickListener { confirmationAction() }
        binding.clearFilter.setOnClickListener { clearAction() }
    }

    private fun confirmationAction() {
        val monthsAdapter = monthsAdapter.getMonthsSelected()
        val categories = categoriesAdapter?.getCategoriesSelected()

        setFragmentResult(
            HomeFilterEvent.doFilter,
            bundleOf("months" to monthsAdapter, "categories" to categories)
        )
        dismiss()
    }

    private fun clearAction() {
        setFragmentResult(
            HomeFilterEvent.doClearFilter,
            bundleOf()
        )
        dismiss()
    }

}