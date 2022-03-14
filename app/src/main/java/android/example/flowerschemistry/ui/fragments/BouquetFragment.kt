package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentBouquetBinding
import androidx.navigation.fragment.findNavController


class BouquetFragment : Fragment() {
    private var _binding: FragmentBouquetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBouquetBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        binding.btnToOrder.setOnClickListener { findNavController().navigate(R.id.action_bouquetFragment_to_orderFragment) }

        return view

    }
}