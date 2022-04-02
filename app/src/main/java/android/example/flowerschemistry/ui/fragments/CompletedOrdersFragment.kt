package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentCompletedOrdersBinding
import android.example.flowerschemistry.data.models.YourOrder
import android.example.flowerschemistry.ui.adapters.OrdersCompletedAdapter
import android.example.flowerschemistry.ui.utils.OnItemClickListenerYourOrder
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager


class CompletedOrdersFragment : Fragment(), OnItemClickListenerYourOrder {
    private var _binding: FragmentCompletedOrdersBinding? = null
    private val binding get() = _binding!!
    private val adapterOrdersCompleted by lazy{ OrdersCompletedAdapter( this@CompletedOrdersFragment) }

    private val itemListOrdersCompleted by lazy {
        arrayListOf(
            YourOrder(1, "Улыбка", "12.02.2021", 4330, "ул.Байтик Баатыра 17/1", "Завершен", R.drawable.image_slider1),
            YourOrder(2, "Шарм", "01.08.2021", 2000, "мкр.Асанбай, д.32, кв.5", "Завершен", R.drawable.image_slider2),
            YourOrder(3, "Шарм", "04.10.2021", 2000, "мкр.Асанбай, д.32, кв.5", "Завершен", R.drawable.image_slider2)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompletedOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        setUpRecyclerViewCompleted()
        return view
    }

    private fun setUpRecyclerViewCompleted() {
        binding.rvMyCompletedOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterOrdersCompleted
            adapterOrdersCompleted.setList(itemListOrdersCompleted)
        }
    }

    override fun onItemClick(item: YourOrder) {
        findNavController().navigate(R.id.action_completedOrdersFragment_to_orderDetailFragment)
    }
}