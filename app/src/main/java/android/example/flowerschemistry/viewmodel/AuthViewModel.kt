package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.User
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: Repository): ViewModel() {

    val userCreated = MutableLiveData<User>()

    fun sendUserData(){
        val response = repository.createUser(userCreated)
    }
}