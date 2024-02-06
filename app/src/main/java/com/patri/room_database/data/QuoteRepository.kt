package com.patri.room_database.data

import com.patri.room_database.data.model.QuoteModel
import com.patri.room_database.data.model.QuoteProvider
import com.patri.room_database.data.network.QuoteService
import javax.inject.Inject

//Va a gestionar los datos

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response

        return response
    }
}
