package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityAuthorizationPhoneBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthorizationPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationPhoneActivity::class.java)
            startActivity(intent)
        }
    }
}