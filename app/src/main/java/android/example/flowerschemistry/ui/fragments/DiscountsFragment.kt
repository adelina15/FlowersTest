package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentDiscountsBinding
import android.example.flowerschemistry.ui.adapters.BouquetDiscountsAdapter
import android.example.flowerschemistry.viewmodel.BouquetDiscountViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel


class DiscountsFragment : Fragment() {
    private var _binding: FragmentDiscountsBinding? = null
    private val binding get() = _binding!!
    private val discountViewModel by viewModel<BouquetDiscountViewModel>()
    private val adapterBouquetDiscountsAdapter by lazy { BouquetDiscountsAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiscountsBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.imBtnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(discountViewModel)
        showProgressBar()
        setupRecyclerViewDiscounts()
        discountViewModel.discountLiveData.observe(viewLifecycleOwner){
            adapterBouquetDiscountsAdapter.setList(it)
            hideProgressBar()
        }
    }

    private fun setupRecyclerViewDiscounts(){
        binding.rvDiscounts.apply {
            adapter = adapterBouquetDiscountsAdapter
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