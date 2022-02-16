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
           // sendVerificationCode(number)
            val intent = Intent(this, AuthorizationSmsCodeActivity::class.java)
            intent.putExtra("phoneNumber", number)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Введите номер телефона", Toast.LENGTH_SHORT).show()
        }
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
