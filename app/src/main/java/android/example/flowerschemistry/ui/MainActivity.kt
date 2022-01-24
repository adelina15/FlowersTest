package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FlowersChemistry) //запуск Splash screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn.setOnClickListener {
            val intent = Intent(this, RegistrationPhoneActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.fragmentContainerView))
    }
}