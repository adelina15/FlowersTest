package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentActiveOrdersBinding
import android.example.flowerschemistry.data.models.YourOrder
import android.example.flowerschemistry.ui.adapters.OrdersActiveAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class ActiveOrdersFragment : Fragment() {
    private var _binding: FragmentActiveOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterOrdersActive by lazy{ OrdersActiveAdapter() }
    private val itemListOrdersActive by lazy {
        arrayListOf(
            YourOrder(1, "Улыбка", "12.02.2021", 4330, "ул.Байтик Баатыра 17/1", "в пути", R.drawable.image_slider1),
            YourOrder(2, "Шарм", "01.08.2021", 2000, "мкр.Асанбай, д.32, кв.5", "в пути", R.drawable.image_slider2)

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewMyOrdersActive()
        return view


    }


    private fun setUpRecyclerViewMyOrdersActive() {
        binding.rvMyActiveOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterOrdersActive
            adapterOrdersActive.setList(itemListOrdersActive)
        }
    }
}