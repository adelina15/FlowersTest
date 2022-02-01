package android.example.flowerschemistry.ui

import android.app.Activity
import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityAuthorizationSmscodeBinding
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AuthorizationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationSmscodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.linearLayoutBack.setOnClickListener {
            val intent = Intent(this, AuthorizationPhoneActivity::class.java)
            startActivity(intent) }

    }
}