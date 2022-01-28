package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityRegistrationPhoneBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegistrationPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, RegistrationSmsCodeActivity::class.java)
            startActivity(intent)
        }
    }
}