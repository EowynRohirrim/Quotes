package com.patri.room_database.domain

import com.patri.room_database.data.QuoteRepository
import com.patri.room_database.data.model.QuoteModel
import com.patri.room_database.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository:QuoteRepository,    private val quoteProvider: QuoteProvider ) {


    //Ahora no necesita una corrutina porque lo tenemos almacenado en QuoteProvider
    operator fun invoke(): QuoteModel? {//Va a coger un QuoteModel

        val quotes = quoteProvider.quotes//almacenamos el listado de citas

        if (!quotes.isNullOrEmpty()) {//Si el listado no es nulo
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]

        }//No hace falta incluir else

        return null//Si está vacio devolverá null. Con return se sale del método
}
}
