package com.patri.room_database.domain

import com.patri.room_database.data.QuoteRepository
import com.patri.room_database.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository) {//CASOS DE USOS

    //Para cuando comienza la app
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()//método estático (invoke())que devuelve una lista de citas con sus autores


}
