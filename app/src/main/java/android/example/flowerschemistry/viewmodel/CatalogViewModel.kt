package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.models.BouquetCatalogItem
import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatalogViewModel(private val repository: Repository): ViewModel() {

    val catalogResponse = MutableLiveData<List<BouquetCatalogItem>>()
    val errorMessage = MutableLiveData<String>()
    //val catalogResponse: LiveData<Response<BouquetCatalogItem>> get() = _catalogResponse

   fun getCatalog(){
       val response = repository.getBouquetCatalog()
       response.enqueue(object : Callback<List<BouquetCatalogItem>> {
           override fun onResponse(call: Call<List<BouquetCatalogItem>>, response: Response<List<BouquetCatalogItem>>) {
               catalogResponse.postValue(response.body())
           }

           override fun onFailure(call: Call<List<BouquetCatalogItem>>, t: Throwable) {
               errorMessage.postValue(t.message)
           }
       })
    }
}
