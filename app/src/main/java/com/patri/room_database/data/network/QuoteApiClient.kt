package com.patri.room_database.data.network

import com.patri.room_database.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>> //suspend porque va dentro de una corrutina

}