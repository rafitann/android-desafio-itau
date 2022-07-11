package com.ncz.android_desafio_itau.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ncz.android_desafio_itau.R
import com.ncz.android_desafio_itau.app.view.adapters.HomeAdapter
import com.ncz.android_desafio_itau.app.viewmodel.HomeViewModel
import com.ncz.android_desafio_itau.databinding.FragmentHomeBinding
import com.ncz.android_desafio_itau.domain.entities.Release
import com.ncz.android_desafio_itau.domain.utils.extensions.OnClick
import com.ncz.android_desafio_itau.domain.utils.states.Status

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var homeAdapter = HomeAdapter()

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        observableReleases()
        homeViewModel.getReleases()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupToolbar() {
        binding.includeToolbar.toolbar.title = getString(R.string.releases)
    }

    private fun observableReleases() {
        homeViewModel.releaseLiveData.observe(viewLifecycleOwner) { release ->
            when (release.status) {
                Status.LOADING ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    release.data?.let { data -> setupAdapter(data) }
                }
                Status.ERROR -> {
                    print("${release.data}")
                }
                else -> {
                    print("${release.data}")
                }
            }
        }
    }

    private fun setupAdapter(release:List<Release>) {
      homeAdapter = HomeAdapter(release)
        binding.releasesRecyclerView.adapter = homeAdapter
        homeAdapter.onClickListener(object : OnClick {
            override fun onCellClickListener(release: Release) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(release))
            }
        })
    }
}