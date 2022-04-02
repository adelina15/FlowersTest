package android.example.flowerschemistry.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentYourOrdersBinding
import android.example.flowerschemistry.ui.adapters.OrdersPagerAdapter
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator

class YourOrdersFragment : Fragment() {
    private var _binding: FragmentYourOrdersBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentYourOrdersBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener { findNavController().popBackStack() }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.ordersViewpager
        val tabLayout = binding.ordersTablayout

        val adapter = OrdersPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val categoryArray = arrayOf(
            "Активные",
            "Завершенные"
        )
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categoryArray[position]
        }.attach()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}