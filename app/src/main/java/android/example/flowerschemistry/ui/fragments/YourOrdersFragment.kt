package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentYourOrdersBinding
import android.example.flowerschemistry.models.YourOrder
import android.example.flowerschemistry.ui.adapters.OrdersActiveAdapter
import android.example.flowerschemistry.ui.adapters.OrdersCompletedAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class YourOrdersFragment : Fragment() {
    private var _binding: FragmentYourOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterOrdersActive by lazy{ OrdersActiveAdapter() }
    private val adapterOrdersCompleted by lazy{  OrdersCompletedAdapter() }

    private val itemListOrdersActive by lazy {
        mutableListOf(
            YourOrder(1, "Улыбка", "12.02.2021", 4330, "ул.Байтик Баатыра 17/1", "в пути", R.drawable.image_slider1),
            YourOrder(2, "Шарм", "01.08.2021", 2000, "мкр.Асанбай, д.32, кв.5", "в пути", R.drawable.image_slider2)

        )
    }

    private val itemListOrdersCompleted by lazy {
        mutableListOf(
            YourOrder(1, "Улыбка", "12.02.2021", 4330, "ул.Байтик Баатыра 17/1", "Завершен", R.drawable.image_slider1),
            YourOrder(2, "Шарм", "01.08.2021", 2000, "мкр.Асанбай, д.32, кв.5", "Завершен", R.drawable.image_slider2),
            YourOrder(3, "Шарм", "04.10.2021", 2000, "мкр.Асанбай, д.32, кв.5", "Завершен", R.drawable.image_slider2)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentYourOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewActive()
        setUpRecyclerViewCompleted()

        return view
    }

    private fun setUpRecyclerViewActive() {
        binding.rvActiveOrder.apply {
            adapter = adapterOrdersActive
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterOrdersActive.setList(itemListOrdersActive)
    }

    private fun setUpRecyclerViewCompleted() {
        binding.rvCompletedOrder.apply {
            adapter = adapterOrdersCompleted
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterOrdersCompleted.setList(itemListOrdersCompleted)
    }
}