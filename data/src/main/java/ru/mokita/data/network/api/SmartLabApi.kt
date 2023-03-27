package ru.mokita.data.network.api

import retrofit2.http.*
import ru.mokita.data.model.*

interface SmartLabApi {
    @POST("sendCode")
    suspend fun sendCode(@Header("email") email: String): CodeResponse

    @POST("signin")
    suspend fun signIn(
        @Header("email") email: String,
        @Header("code") code: String
    ): Token

    @GET("catalog")
    suspend fun getCatalog(): List<CatalogItem>

    @GET("news")
    suspend fun getNews(): List<News>

    @POST("createProfile")
    suspend fun createProfile(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("middleName") middleName: String,
        @Query("bith") bithday: String? = null,
        @Query("pol") gender: String? = null,
        ): Profile

    @POST("order")
    suspend fun createOrder(): Int

    @GET("orders")
    suspend fun getOrders(): List<OrdersItem>
}