package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.example.flowerschemistry.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.example.flowerschemistry.ui.RegistrationSmsCodeActivity
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val userViewModel by viewModel<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

       /*binding.btnSave.setOnClickListener {
            val intent = Intent(requireContext(), RegistrationSmsCodeActivity::class.java)
            startActivity(intent) }*/

        binding.btnSave.setOnClickListener {

        }

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        return view
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.isEnabled = false
        val editTexts = listOf(binding.edName, binding.edTextPhone)
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    var et1 = binding.edName.text.toString().trim()
                    var et2 = binding.edTextPhone.text.toString().trim()

                    binding.btnSave.isEnabled = et1.isNotEmpty()
                            && et2.isNotEmpty()

                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int, after: Int) {
                }

                override fun afterTextChanged(
                    s: Editable) {
                }
            })
        }
    }*/

    private fun createUser(number: String, name: String) {
        userViewModel.createUser(number, name)

        }

    }

}