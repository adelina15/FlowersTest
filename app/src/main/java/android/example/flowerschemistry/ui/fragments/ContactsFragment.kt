package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.example.flowerschemistry.databinding.FragmentContactsBinding
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


class ContactsFragment : Fragment() {
    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }

        binding.tvLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/TLFozjhAZdhHVuSH6"))
            startActivity(intent)
        }

        return view
    }

}