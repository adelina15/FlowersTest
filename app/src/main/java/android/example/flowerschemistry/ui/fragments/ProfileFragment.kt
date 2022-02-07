package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.example.flowerschemistry.ui.RegistrationPhoneActivity
import android.example.flowerschemistry.ui.RegistrationSmsCodeActivity


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

       binding.btnSave.setOnClickListener {
            val intent = Intent(requireContext(), RegistrationSmsCodeActivity::class.java)
            startActivity(intent)
        }
        return view

    }
}