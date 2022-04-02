package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.BouquetSelectionItem
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class BouquetDiscountViewModel(private val repository: Repository): ViewModel(),
    DefaultLifecycleObserver {

    val discountLiveData = MutableLiveData<ArrayList<BouquetSelectionItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getDiscountBouquet()
    }

    fun getDiscountBouquet() {
        viewModelScope.launch {
            val response = repository.getBouquetDiscount()
            if (response.isSuccessful) {
                discountLiveData.postValue(response.body())
            }
        }
    }
}