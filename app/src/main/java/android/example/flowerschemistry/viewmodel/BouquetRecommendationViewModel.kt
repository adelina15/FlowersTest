package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.BouquetSelectionItem
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BouquetRecommendationViewModel(private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    val recommendationLiveData = MutableLiveData<ArrayList<BouquetSelectionItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getRecommendationBouquet()
    }

    fun getRecommendationBouquet(){
        viewModelScope.launch {
            val response = repository.getBouquetRecommendation()
            if (response.isSuccessful){
                recommendationLiveData.postValue(response.body())
            }
        }
    }
}