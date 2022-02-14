package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityAuthorizationPhoneBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast

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
            validatePhone()
        }
    }

    private fun validatePhone(): Boolean {
        val phoneInput = binding.edTextPhone.text.toString()
        return if (phoneInput.length == 9 ) {
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            startActivity(intent)
            true
        } else {
            Toast.makeText(this, "Введите номер телефона", Toast.LENGTH_LONG).show()
            false
        }
    }
}
