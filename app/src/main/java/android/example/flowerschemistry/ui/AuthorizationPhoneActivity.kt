package android.example.flowerschemistry.ui

import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityAuthorizationPhoneBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

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

        auth=FirebaseAuth.getInstance()
        binding.btnNext.setOnClickListener {
            login()
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            intent.putExtra("phoneNumber", number)
            startActivity(intent)
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            // Этот метод вызывается после завершения проверки
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
                Log.d("GFG" , "Верификация прошла успешно")
            }

            // Вызывается, когда проверка не удалась
            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("GFG" , "Верификация не удалась $e")
            }

            // При отправке кода Firebase вызывается этот метод
            //здесь мы начинаем новую активность, в которой пользователь может ввести OTP
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("GFG","onCodeSent: $verificationId")
                storedVerificationId = verificationId
                resendToken = token
                //Запускаем новую activity, используя intent
                //Используем id для отправки otp обратно в firebase
                val intent = Intent(applicationContext,AuthorizationSmsCodeActivity::class.java)
                intent.putExtra("storedVerificationId",storedVerificationId)
                startActivity(intent)
                finish()
            }
        }

        binding.tvSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

       /* binding.btnNext.setOnClickListener {
            validatePhone()
        }*/
    }

    private fun login() {
        //получить номер телефона из editText
        number = binding.edTextPhone.text.trim().toString()
        if (number.isNotEmpty()){
            sendVerificationCode(number)
        }else{
            Toast.makeText(this,"Введите номер телефона", Toast.LENGTH_SHORT).show()
        }
    }

    // этот метод отправляет код подтверждения и запускает обратный вызов проверки
    // который реализован выше в onCreate
    private fun sendVerificationCode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Номер телефона для подтверждения
            .setTimeout(60L, TimeUnit.SECONDS) // Время для подтверждения смс кода
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        Log.d("GFG" , "Авторизация началась")
    }

    /*?private fun validatePhone(): Boolean {
        val phoneInput = binding.edTextPhone.text.toString()
        return if (phoneInput.length == 9 ) {
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            startActivity(intent)
            true
        } else {
            Toast.makeText(this, "Введите номер телефона полностью", Toast.LENGTH_LONG).show()
            false
        }
    }*/

}
