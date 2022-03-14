package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentSenderReceiverBinding
import android.example.flowerschemistry.ui.AuthorizationPhoneActivity
import android.example.flowerschemistry.ui.MainActivity
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController


class SenderReceiverFragment : Fragment() {
    private var _binding: FragmentSenderReceiverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =   FragmentSenderReceiverBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ivBack.setOnClickListener { findNavController().navigateUp() }

        //AlertDialog о том, что заказ принят
        binding.btnToOrder.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext(),R.style.CustomAlertDialog)
                .create()
            val view = layoutInflater.inflate(R.layout.alert_dialog_order_accepted,null)
            builder.setView(view)
            view.findViewById<Button>(R.id.btn_go_to_home).setOnClickListener {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }

            view.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
                builder.dismiss()
            }

            builder.setCanceledOnTouchOutside(false)
            builder.show()
        }
       /*binding.btnToOrder.setOnClickListener {
           val view = View.inflate(requireContext(), R.layout.alert_dialog_order_accepted, null)
           val builder = AlertDialog.Builder(requireContext())
           builder.setView(view)

           val dialog = builder.create()
           dialog.show()
           dialog.window?.setBackgroundDrawableResource(android.R.color.white)

           view.findViewById<Button>(R.id.btn_go_to_home).setOnClickListener {
               val intent = Intent(requireContext(), MainActivity::class.java)
               startActivity(intent)
           }

           view.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
               dialog.dismiss()
           }
       }*/

        return view
    }

}
