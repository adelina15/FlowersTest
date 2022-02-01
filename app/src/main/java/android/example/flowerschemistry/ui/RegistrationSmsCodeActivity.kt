package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityRegistrationSmsCodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegistrationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationSmsCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationSmsCodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.linearLayoutBack.setOnClickListener {
            val intent = Intent(this, RegistrationPhoneActivity::class.java)
            startActivity(intent) }
    }
}