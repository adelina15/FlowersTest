package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentHomeBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.models.Card
import android.example.flowerschemistry.ui.adapters.CardsFirstRowAdapter
import android.example.flowerschemistry.ui.adapters.CardsSecondRowAdapter
import android.example.flowerschemistry.ui.adapters.CardsThirdRowAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapterFirstRow by lazy{ CardsFirstRowAdapter() }
    private val adapterSecondRow by lazy{ CardsSecondRowAdapter() }
    private val adapterThirdRow by lazy{ CardsThirdRowAdapter() }
    private val itemListFirstRow by lazy{
        mutableListOf(
            Card(1, "Для день рождения", R.drawable.card1),
            Card(2, "Для любимой", R.drawable.card2),
            Card(3, "Рождение ребенка", R.drawable.card3),
            Card(4, "Тематический", R.drawable.card4))
    }
    private val itemListSecondRow by lazy{
        mutableListOf(
            Card(1, "Для девушки", R.drawable.card5),
            Card(2, "Для коллеги", R.drawable.card6))

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

        binding.rvFirstRow.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvFirstRow.adapter = adapterFirstRow
        adapterFirstRow.setList(itemListFirstRow)
        adapterFirstRow.notifyDataSetChanged()

        binding.rvSecondRow.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvSecondRow.adapter = adapterSecondRow
        adapterSecondRow.setList(itemListSecondRow)
        adapterFirstRow.notifyDataSetChanged()

        binding.rvThirdRow.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvThirdRow.adapter = adapterThirdRow
        adapterThirdRow.setList(itemListThirdRow)
        adapterThirdRow.notifyDataSetChanged()

        return view

    }

}