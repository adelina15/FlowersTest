package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentPopularBinding
import android.example.flowerschemistry.ui.adapters.BouquetPopularAdapter
import android.example.flowerschemistry.viewmodel.BouquetPopularViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel


class PopularFragment : Fragment() {
    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!
    private val popularViewModel by viewModel<BouquetPopularViewModel>()
    private val adapterBouquetPopularAdapter by lazy { BouquetPopularAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(popularViewModel)
        showProgressBar()
        setupRecyclerViewPopular()
        popularViewModel.popularLiveData.observe(viewLifecycleOwner){
            adapterBouquetPopularAdapter.setList(it)
            hideProgressBar()
        }
    }

    private fun setupRecyclerViewPopular(){
        binding.rvPopular.apply {
            adapter = adapterBouquetPopularAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }
}