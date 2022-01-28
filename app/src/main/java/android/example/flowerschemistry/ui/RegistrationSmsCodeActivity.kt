package android.example.flowerschemistry.ui

import android.app.Activity
import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityRegistrationSmscodeBinding
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistrationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationSmscodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.linearLayoutBack.setOnClickListener {
            val intent = Intent(this, RegistrationPhoneActivity::class.java)
            startActivity(intent) }
    }
}