package android.example.flowerschemistry.api

import android.example.flowerschemistry.models.BouquetCatalogItem
import android.example.flowerschemistry.models.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface InterfaceAPI {

    @GET("bouquet")
    fun getBouquetCatalog(): Call<List<BouquetCatalogItem>>

    @POST("auth/login/client")
    fun createUser(
        @Field("phoneNumber") phoneNumber: String
    ) : Response<String>
}