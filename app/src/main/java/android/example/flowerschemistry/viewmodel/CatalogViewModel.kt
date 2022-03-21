package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.BouquetCatalogItemItem
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class CatalogViewModel(private val repository: Repository): ViewModel(), DefaultLifecycleObserver {

   val catalogLiveData = MutableLiveData<ArrayList<BouquetCatalogItemItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getCatalogBouquet()
    }

    fun getCatalogBouquet(){
        viewModelScope.launch {
            val response = repository.getBouquetCatalog()
            if (response.isSuccessful){
                catalogLiveData.postValue(response.body())
            }
        }
    }
}
