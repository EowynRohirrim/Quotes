package com.patri.room_database.data.network

import com.patri.room_database.core.RetrofitHelper
import com.patri.room_database.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuoteService @Inject constructor(private val api:QuoteApiClient) { //Comunicacion entre el servicio y la app

//Se borra retrofit porque no se puede injectar retrofit
    suspend fun getQuotes(): List<QuoteModel> { // Coge las citas de la api
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes() //va a tener todo el listado de citas
            response.body() ?: emptyList()//nos quedamos con el cuerpo, si no se conecta bien, genera lista vacía
        }
    }}
