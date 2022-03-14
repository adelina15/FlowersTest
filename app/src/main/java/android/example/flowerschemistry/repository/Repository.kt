package android.example.flowerschemistry.repository

import android.example.flowerschemistry.api.InterfaceAPI
import android.example.flowerschemistry.models.User
import retrofit2.Response


class Repository constructor(private val serviceAPI: InterfaceAPI){

    fun getBouquetCatalog() = serviceAPI.getBouquetCatalog()

    fun createUser(phoneNumber: String):Response<String>{
        return serviceAPI.createUser(phoneNumber)
    }

}