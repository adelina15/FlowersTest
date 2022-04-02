package android.example.flowerschemistry.repository

import android.example.flowerschemistry.api.InterfaceAPI
import android.example.flowerschemistry.models.BouquetCatalogItemItem
import android.example.flowerschemistry.models.BouquetSelectionItem
import android.example.flowerschemistry.models.User
import retrofit2.Response


class Repository constructor(private val serviceAPI: InterfaceAPI){

    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>{
        return serviceAPI.getBouquetCatalog()
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

}