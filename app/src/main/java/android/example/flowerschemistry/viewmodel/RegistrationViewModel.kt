package android.example.flowerschemistry.viewmodel


import android.example.flowerschemistry.data.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

    val userCreated = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
    }

    fun createUser(number:String, name:String){
        viewModelScope.launch {
            val response = repository.createUser(number, name)
            if (response.isSuccessful)
               {
                    userCreated.postValue(true)
                }
            else {
                userCreated.postValue(false)
                errorMessage.postValue(response.errorBody().toString())
            }
        }
    }
}