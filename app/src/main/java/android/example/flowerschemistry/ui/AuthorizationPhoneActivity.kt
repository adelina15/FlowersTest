package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.data.UserPreferences
import android.example.flowerschemistry.databinding.ActivityAuthorizationPhoneBinding
import android.example.flowerschemistry.viewmodel.AuthViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.auth0.android.jwt.Claim
import com.auth0.android.jwt.JWT
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import org.koin.android.viewmodel.ext.android.viewModel


class AuthorizationPhoneActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationPhoneBinding
    var number : String =""
    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnNext.setOnClickListener {
            login()
        }


        binding.tvSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        //получить номер телефона из editText
        number = binding.edTextPhone.text.trim().toString()
        if (number.isNotEmpty()){
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            intent.putExtra("phoneNumber", number)
            startActivity(intent)

        }else{
            Toast.makeText(this,"Введите номер телефона", Toast.LENGTH_SHORT).show()
        }
    }


}