package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.BouquetSelectionItem
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BouquetPopularViewModel(private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    val popularLiveData = MutableLiveData<ArrayList<BouquetSelectionItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getPopularBouquet()
    }

    fun getPopularBouquet() {
        viewModelScope.launch {
            val response = repository.getBouquetPopular()
            if (response.isSuccessful) {
                popularLiveData.postValue(response.body())
            }
        }
    }
}