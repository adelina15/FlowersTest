package android.example.flowerschemistry.repository

import android.example.flowerschemistry.api.InterfaceAPI
import android.example.flowerschemistry.models.BouquetCatalogItemItem
import retrofit2.Response


class Repository constructor(private val serviceAPI: InterfaceAPI){

    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>{
        return serviceAPI.getBouquetCatalog()
    }

    /*fun createUser(phoneNumber: String):Response<String>{
        return serviceAPI.createUser(phoneNumber)
    }*/

}