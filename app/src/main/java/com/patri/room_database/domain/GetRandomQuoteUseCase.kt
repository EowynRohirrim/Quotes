package com.patri.room_database.domain

import com.patri.room_database.data.QuoteRepository
import com.patri.room_database.data.model.QuoteModel
import com.patri.room_database.data.model.QuoteProvider
import com.patri.room_database.domain.model.Quote
import javax.inject.Inject

/**Declara como inyectable*/
class GetRandomQuoteUseCase @Inject constructor(private val repository:QuoteRepository) {


    //Ahora no necesita una corrutina porque lo tenemos almacenado en QuoteProvider
    suspend operator fun invoke(): Quote? {//Va a coger un QuoteModel

        val quotes = repository.getAllQuotesFromDatabase() //pasando por repositorio coger todas las citas de la base de datos

        if (!quotes.isNullOrEmpty()) {//Si el listado no es nulo
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]

        }//No hace falta incluir else

        return null//Si está vacio devolverá null. Con return se sale del método
}
}
