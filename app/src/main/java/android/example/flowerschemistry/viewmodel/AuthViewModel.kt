package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.data.models.Token
import android.example.flowerschemistry.data.repository.Repository
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val token = MutableLiveData<Token>()
    val errorMessage = MutableLiveData<String>()


    fun getToken(number: String) {
        viewModelScope.launch {
            val response = repository.getToken(number)
            if (response.isSuccessful) {
                token.postValue(response.body())
            }
            else{
                errorMessage.postValue(response.errorBody().toString())
            }
        }
    }
}