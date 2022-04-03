package android.example.flowerschemistry.data.repository

import android.example.flowerschemistry.data.api.InterfaceAPI
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.data.models.BouquetSelectionItem
import android.example.flowerschemistry.data.models.Token
import android.example.flowerschemistry.data.models.User
import retrofit2.Response


class Repository constructor(private val serviceAPI: InterfaceAPI){

    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>{
        return  serviceAPI.getBouquetCatalog()
    }

    suspend fun getBouquetRecommendation(): Response<ArrayList<BouquetSelectionItem>>{
        return serviceAPI.getBouquetRecommendation()
    }

    suspend fun getBouquetPopular(): Response<ArrayList<BouquetSelectionItem>>{
        return serviceAPI.getBouquetPopular()
    }

    suspend fun getBouquetDiscount(): Response<ArrayList<BouquetSelectionItem>>{
        return serviceAPI.getBouquetDiscount()
    }

    suspend fun createUser(number: String, name: String): Response<User> {
        return serviceAPI.createUser(number, name)
    }

    suspend fun checkNumber(number: String): Response<Boolean> {
        return serviceAPI.checkUserNumber(number)
    }

    suspend fun getToken(number: String): Response<Token> {
        return serviceAPI.getToken(number)
    }

}

interface SafeApiCall {
    suspend fun<T> safeApiCall(apiCall: suspend () -> T) : Resource<T>  {
        return try {
            Resource.Success(apiCall.invoke())
        } catch (e: Throwable) {
            Resource.Error(e)
        }
    }
}

sealed class Resource<out T>() {
    data class Success<out T>(val data: T) : Resource<T>()
    class Error(throwable: Throwable) : Resource<Nothing>()
}