package android.example.flowerschemistry.ui

import android.example.flowerschemistry.databinding.ActivityAuthorizationSmscodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthorizationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationSmscodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.linearLayoutBack.setOnClickListener {
            onBackPressed()
        }

    }
}