package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentHomeBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.models.Card
import android.example.flowerschemistry.ui.adapters.CardsAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy{ CardsAdapter() }
    private val itemList by lazy{
        mutableListOf(
            Card(1, "Для день рождения", R.drawable.card1),
            Card(2, "Для любимой", R.drawable.card2),
            Card(3, "Рождение ребенка", R.drawable.card3),
            Card(4, "Просто так", R.drawable.bouquet))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = adapter
        adapter.setList(itemList)
        adapter.notifyDataSetChanged()
        return view

    }

}