package android.example.flowerschemistry.ui.fragments


import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentHomeBinding
import android.example.flowerschemistry.models.BouquetDiscounts
import android.example.flowerschemistry.models.BouquetPopular
import android.example.flowerschemistry.models.BouquetRecommendation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.models.Card
import android.example.flowerschemistry.ui.adapters.*
import android.example.flowerschemistry.viewmodel.BouquetDiscountViewModel
import android.example.flowerschemistry.viewmodel.BouquetPopularViewModel
import android.example.flowerschemistry.viewmodel.BouquetRecommendationViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val recommendationViewModel by viewModel<BouquetRecommendationViewModel>()
    private val popularViewModel by viewModel<BouquetPopularViewModel>()
    private val discountViewModel by viewModel<BouquetDiscountViewModel>()
    private val adapterFirstRow by lazy{ CardsFirstRowAdapter() }
    private val adapterSecondRow by lazy{ CardsSecondRowAdapter() }
    private val adapterThirdRow by lazy{ CardsThirdRowAdapter() }
    private val adapterBouquetRecommendationAdapter by lazy {BouquetRecommendationAdapter()}
    private val adapterBouquetDiscountsAdapter by lazy {BouquetDiscountsAdapter()}
    private val adapterBouquetPopularAdapter by lazy {BouquetPopularAdapter()}
    private val itemListFirstRow by lazy{
        mutableListOf(
            Card(1, "На день рожденияя", R.drawable.card1),
            Card(2, "Для любимой", R.drawable.card2),
            Card(3, "Рождение ребенка", R.drawable.card3),
            Card(4, "Тематический", R.drawable.card4))
    }
    private val itemListSecondRow by lazy{
        mutableListOf(
            Card(1, "Для девушки", R.drawable.for_girlfriend),
            Card(2, "Для коллеги", R.drawable.for_collegs))

    }

    private val itemListThirdRow by lazy{
        mutableListOf(
            Card(1, "Домашние цветы", R.drawable.card7),
            Card(2, "Домашние цветы", R.drawable.card8))

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewFirstRow()
        setUpRecyclerViewSecondRow()
        setUpRecyclerViewThirdRow()

        binding.btnToCatalog.setOnClickListener { Navigation.findNavController(view)
            .navigate(R.id.action_homeFragment_to_catalogFragment) }

        binding.contenierAllRec.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_recommendationFragment)
        }

        binding.contenierAllPopular.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_popularFragment)
        }

        binding.contenierAllDiscount.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_discountsFragment)
        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycle.addObserver(recommendationViewModel)
        setUpRecyclerViewRecommended()
        recommendationViewModel.recommendationLiveData.observe(viewLifecycleOwner){
            adapterBouquetRecommendationAdapter.setList(it)
        }

        lifecycle.addObserver(popularViewModel)
        setUpRecyclerViewPopular()
        popularViewModel.popularLiveData.observe(viewLifecycleOwner){
            adapterBouquetPopularAdapter.setList(it)
        }

        lifecycle.addObserver(discountViewModel)
        setUpRecyclerViewDiscounts()
        discountViewModel.discountLiveData.observe(viewLifecycleOwner){
            adapterBouquetDiscountsAdapter.setList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun setUpRecyclerViewFirstRow() {
        binding.rvFirstRow.apply {
            adapter = adapterFirstRow
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        adapterFirstRow.setList(itemListFirstRow)
    }

    private fun setUpRecyclerViewSecondRow() {
        binding.rvSecondRow.apply {
            adapter = adapterSecondRow
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        adapterSecondRow.setList(itemListSecondRow)
    }

    private fun setUpRecyclerViewThirdRow() {
        binding.rvThirdRow.apply {
            adapter = adapterThirdRow
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        adapterThirdRow.setList(itemListThirdRow)
    }

    private fun setUpRecyclerViewRecommended() {
        binding.rvRecommended.apply {
            adapter = adapterBouquetRecommendationAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setUpRecyclerViewDiscounts() {
        binding.rvDiscounts.apply {
            adapter = adapterBouquetDiscountsAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setUpRecyclerViewPopular() {
        binding.rvPopular.apply {
            adapter = adapterBouquetPopularAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

}