package android.example.flowerschemistry

import android.example.flowerschemistry.databinding.ActivityRegistrationSmscodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegistrationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationSmscodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}