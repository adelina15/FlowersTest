package android.example.flowerschemistry.ui


import android.app.Activity
import android.content.Intent
import android.example.flowerschemistry.databinding.ActivityAuthorizationSmscodeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class AuthorizationSmsCodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationSmscodeBinding
    lateinit var auth: FirebaseAuth
    private var id: String = ""
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private val number by lazy { intent.getStringExtra("phoneNumber") }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationSmscodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        auth=FirebaseAuth.getInstance()

        binding.tvPhoneNumber.text = number.toString()
        startTimer()

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
                p0: String, p1: PhoneAuthProvider.ForceResendingToken
            ) {
                id = p0
                Toast.makeText(this@AuthorizationSmsCodeActivity,
                    "Сообщение отправленно", Toast.LENGTH_LONG).show()
            }
        }

        sendVerificationCode()

        
        // заполняем otp и вызывем по нажатии на кнопку
        binding.btnNext.setOnClickListener {
            val otp = binding.pinView.text?.trim().toString()
            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    id, otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSkip.setOnClickListener {
            resendOTP(this, number.toString())
            startTimer()
        }

        binding.linearLayoutBack.setOnClickListener {
            onBackPressed()
        }

    }


    // этот метод отправляет код подтверждения и запускает обратный вызов проверки
    // который реализован выше в onCreate
    private fun sendVerificationCode() {
        PhoneAuthOptions.newBuilder()
            .setActivity(this)
            .setPhoneNumber(number!!)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(callbacks)
            .build()
            .apply {
                PhoneAuthProvider.verifyPhoneNumber(this)
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

    private fun resendOTP(activity: Activity, number: String){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .setForceResendingToken(resendToken!!) // ForceResendingToken from callbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    // Зпуск таймера чтобы пользователь за 60 сек ввел смс код
    private fun startTimer() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "Осталось: 00:${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.tvTimer.text = "Время вышло"
            }
        }.start()
    }
}

