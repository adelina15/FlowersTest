package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.example.flowerschemistry.R
import androidx.fragment.app.Fragment
import android.example.flowerschemistry.databinding.FragmentMoreBinding
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.example.flowerschemistry.ui.RegistrationSmsCodeActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import kotlin.concurrent.fixedRateTimer


class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnProfile.setOnClickListener { Navigation.findNavController(view)
            .navigate(R.id.action_moreFragment_to_profileFragment) }

        return view

    }
}


