package android.example.flowerschemistry.api

import android.example.flowerschemistry.models.BouquetCatalogItemItem
import retrofit2.Response
import retrofit2.http.GET

interface InterfaceAPI {

    @GET("bouquet")
    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>

   /* @POST("auth/login/client")
    fun createUser(
        @Field("phoneNumber") phoneNumber: String
    ) : Response<String>*/
}