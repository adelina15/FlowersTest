package android.example.flowerschemistry.ui

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class   MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FlowersChemistry) //запуск Splash screen
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //binding.bottomNavigationView.setupWithNavController(findNavController(R.id.fragmentContainerView))

        setupBottomNavigationView()

    }

    private fun setupBottomNavigationView() {
        val navController = findNavController(R.id.fragmentContainerView)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.basketFragment -> showBottomNav()
                R.id.catalogFragment -> showBottomNav()
                R.id.favoritesFragment -> showBottomNav()
                R.id.moreFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavigationView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE

    }
}

