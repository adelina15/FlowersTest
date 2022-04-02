package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentOrderBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.data.models.ToOrder
import android.example.flowerschemistry.ui.adapters.ToOrderAdapter
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager


class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private val adapterToOrder by lazy{ ToOrderAdapter() }

    private val itemListToOrder by lazy {
        mutableListOf(
            ToOrder(1, "Грёзы", 2300, 2, R.drawable.img_basket)
            //ToOrder(2, "Рафаэло", 500, 1, R.drawable.img_basket),
           // ToOrder(3, "Букет осенний блюз", 4000, 3, R.drawable.image_slider3),
            //ToOrder(4, "Открытка", 100, 1, R.drawable.card3)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnOrder.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_orderFragment_to_senderReceiverFragment)
        }

        binding.btnPickup.setOnClickListener {
            binding.btnPickup.isSelected = !binding.btnPickup.isSelected
            binding.btnDelivery.isSelected = !binding.btnDelivery.isSelected.not()
            binding.lineDelivery.visibility = View.INVISIBLE
            binding.lineSum.visibility = View.INVISIBLE
        }

        binding.btnDelivery.setOnClickListener {
            binding.btnDelivery.isSelected = !binding.btnDelivery.isSelected
            binding.btnPickup.isSelected = !binding.btnPickup.isSelected.not()
            binding.lineDelivery.visibility = View.VISIBLE
            binding.lineSum.visibility = View.VISIBLE
        }

        setUpRecyclerView()

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        return view
    }

    private fun setUpRecyclerView() {
        binding.rvToOrder.apply {
            adapter = adapterToOrder
            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterToOrder.setList(itemListToOrder)
    }
}