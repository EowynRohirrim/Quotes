package com.patri.room_database.data

import com.patri.room_database.data.database.dao.QuoteDao
import com.patri.room_database.data.database.entities.QuoteEntity
import com.patri.room_database.data.model.QuoteModel
import com.patri.room_database.data.model.QuoteProvider
import com.patri.room_database.data.network.QuoteService
import com.patri.room_database.domain.model.Quote
import com.patri.room_database.domain.model.toDomain
import javax.inject.Inject

//Va a gestionar los datos

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteDao: QuoteDao){

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response:List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain()}

    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {

        val response: List<QuoteEntity> = quoteDao.getAllQuotes() //inyecta el quoteDao
        return response.map { it.toDomain() }
    }


    suspend fun insertQuotes(quotes:List<QuoteEntity>){//Tiene que ser una lista d eobjetos quoteentity
        quoteDao.insertAll(quotes)
    }
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }


}
