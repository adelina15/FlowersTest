package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentRecommendationBinding
import android.example.flowerschemistry.ui.adapters.BouquetRecommendationAdapter
import android.example.flowerschemistry.viewmodel.BouquetRecommendationViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

class RecommendationFragment : Fragment() {
    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!
    private val recommendationViewModel by viewModel<BouquetRecommendationViewModel>()
    private val adapterBouquetRecommendationAdapter by lazy { BouquetRecommendationAdapter() }
    /*private val itemListBouquetRecommendation by lazy {
        mutableListOf(
            BouquetRecommendation(1, "Букет осенний блюз", 999, "Розы, ромашки, лилии",R.drawable.bouquet ),
            BouquetRecommendation(2, "Букет осенний блюз", 999, "Розы, ромашки, лилии",R.drawable.bouquet ),
            BouquetRecommendation(3, "Букет осенний блюз", 999, "Розы, ромашки, лилии",R.drawable.bouquet )
        )
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecommendationBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.imBtnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(recommendationViewModel)
        showProgressBar()
        setupRecyclerViewRecommendation()
        recommendationViewModel.recommendationLiveData.observe(viewLifecycleOwner){
            adapterBouquetRecommendationAdapter.setList(it)
            hideProgressBar()
        }
    }

    private fun setupRecyclerViewRecommendation(){
        binding.rvRecommendation.apply {
            adapter = adapterBouquetRecommendationAdapter
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