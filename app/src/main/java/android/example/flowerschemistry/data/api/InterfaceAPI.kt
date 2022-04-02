package android.example.flowerschemistry.data.api

import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import android.example.flowerschemistry.data.models.BouquetSelectionItem
import android.example.flowerschemistry.data.models.Token
import android.example.flowerschemistry.data.models.User
import retrofit2.Response
import retrofit2.http.*

interface InterfaceAPI {

    @GET("bouquet")
    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>

    @GET("bouquet/selection?selection=Рекомендации")
    suspend fun getBouquetRecommendation(): Response<ArrayList<BouquetSelectionItem>>

    @GET("bouquet/selection?selection=Популярные")
    suspend fun getBouquetPopular(): Response<ArrayList<BouquetSelectionItem>>

    @GET("bouquet/selection?selection=Скидки%2020%25")
    suspend fun getBouquetDiscount(): Response<ArrayList<BouquetSelectionItem>>

    suspend fun checkUserNumber(number: String): Response<Boolean>

    @FormUrlEncoded
    @POST("client/create")
    suspend fun createUser(
        @Field("phoneNumber") phoneNumber: String,
        @Field("name") name: String
    ): Response<User>

    @FormUrlEncoded
    @POST("auth/login/client")
    suspend fun getToken(
        @Field("phoneNumber") phoneNumber: String,
    ): Response<Token>

}