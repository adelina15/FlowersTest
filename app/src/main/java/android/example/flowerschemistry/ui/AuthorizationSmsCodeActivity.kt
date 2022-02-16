package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ActivityAuthorizationSmscodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class AuthorizationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationSmscodeBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()

        // получаем сохранненый storedVerificationId из intent
        val storedVerificationId= intent.getStringExtra("storedVerificationId")
        binding.tvPhoneNumber.text = getIntent().getStringExtra("phoneNumber")

        // заполняем otp и вызывем по нажатии на кнопку
        binding.btnNext.setOnClickListener {
            val otp = binding.pinView.text?.trim().toString()
            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }

        binding.linearLayoutBack.setOnClickListener {
            onBackPressed()
        }

    }

    // проверяем, соответствует ли код, отправленный firebase
    // в случае успеха запускаем новое activity
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this , MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // если ошибка входа, отобразится сообщение
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // Введенный код подтверждения недействителен
                        Toast.makeText(this,"Неверный код", Toast.LENGTH_SHORT).show()
                        binding.tvIncorrectCode.visibility = View.VISIBLE
                    }
                }
            }
    }
}

