package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.databinding.FragmentContactsBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.widget.Toast
import com.klinker.android.link_builder.Link
import com.klinker.android.link_builder.applyLinks
import java.util.regex.Pattern


class ContactsFragment : Fragment() {
    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

}