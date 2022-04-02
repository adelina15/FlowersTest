package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.example.flowerschemistry.R
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.data.models.User
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.flowerschemistry.databinding.FragmentProfileBinding
import android.example.flowerschemistry.viewmodel.AuthViewModel
import android.example.flowerschemistry.viewmodel.RegistrationViewModel
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.viewModel


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val userViewModel by viewModel<RegistrationViewModel>()
    private val authViewModel by viewModel<AuthViewModel>()
    lateinit var sharedPreferences: UserPreferences
    lateinit var name: String
    lateinit var number: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedPreferences =  UserPreferences(requireContext())
        binding.imBtnBack.setOnClickListener { findNavController().navigateUp() }
        binding.btnSave.setOnClickListener {
            name = binding.edName.text.toString()
            number = binding.edTextPhone.text.toString()
            createUser(number, name)
            check(number, name)
        }

        binding.btnCancel.setOnClickListener {
            sharedPreferences.delete()
            Log.i("delete", sharedPreferences.fetchToken().toString())
            data()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data()
    }

    private fun createUser(number: String, name: String) {
        userViewModel.createUser(number, name)

    }

    private fun check(number: String, name: String){
        userViewModel.userCreated.observe(viewLifecycleOwner){
            if (it == true){
                sharedPreferences.saveUserName(name)
                sharedPreferences.saveUserNumber(number)
                val token: String = authViewModel.getToken(number).toString()
                Log.i("token", token)
                sharedPreferences.saveToken(token)
                val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                findNavController().navigate(action)
            }
            else {
                Toast.makeText(context, "Произошла ошибка", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showData(){
        val name = sharedPreferences.fetchUserName()
        val number = sharedPreferences.fetchUserNumber()
        binding.name.text = name
        binding.number.text = number.toString()
        binding.name.visibility = View.VISIBLE
        binding.cardview1.visibility = View.GONE
        binding.number.visibility = View.VISIBLE
        binding.cardview2.visibility = View.GONE
    }

    private fun hideData(){
        binding.cardview1.visibility = View.VISIBLE
        binding.name.visibility = View.GONE
        binding.cardview2.visibility = View.VISIBLE
        binding.number.visibility = View.GONE
    }

    private fun data(){
        if (sharedPreferences.fetchToken() != null){
            showData()
        } else{
            hideData()
        }
    }

}

