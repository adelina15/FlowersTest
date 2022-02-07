package android.example.flowerschemistry.ui.fragments


import android.content.Intent
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentFavoritesBinding
import android.example.flowerschemistry.databinding.FragmentMoreBinding
import android.example.flowerschemistry.ui.AuthorizationPhoneActivity
import android.example.flowerschemistry.ui.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //AlertDialog для авторизации
        val builder = AlertDialog.Builder(requireContext(),R.style.CustomAlertDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.customview_layout,null)
        val buttonAuth = view.findViewById<Button>(R.id.btn_authorization)
        val buttonSkip = view.findViewById<Button>(R.id.btn_skip)
        builder.setView(view)
        buttonAuth.setOnClickListener {
            val intent = Intent(requireContext(), AuthorizationPhoneActivity::class.java)
            startActivity(intent)
        }

        buttonSkip.setOnClickListener {
            builder.dismiss()
        }

        builder.setCanceledOnTouchOutside(false)
        builder.show()
    }
}