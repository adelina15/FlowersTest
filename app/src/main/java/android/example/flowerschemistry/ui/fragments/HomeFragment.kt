package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentHomeBinding
import android.example.flowerschemistry.models.Card
import android.example.flowerschemistry.ui.adapters.CardsAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var cardsAdapter: CardsAdapter
    private val itemList by lazy{
        mutableListOf(
            Card(1, "Для день рождения", R.drawable.card1),
            Card(2, "Для любимой", R.drawable.card2),
            Card(3, "Рождение ребенка", R.drawable.card3))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        setupRecyclerView()
        return view

    }

    private fun  setupRecyclerView(){
        cardsAdapter = CardsAdapter()
        binding.rvCategory.apply {
            adapter = cardsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}