package com.patri.room_database.domain

import com.patri.room_database.data.QuoteRepository
import com.patri.room_database.data.database.entities.toDatabase
import com.patri.room_database.domain.model.Quote
import javax.inject.Inject



/**Declarada como inyectable*/
class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository) {//CASOS DE USOS

    //Para cuando comienza la app

    //método estático (invoke())que devuelve una lista de citas con sus autores
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes() //Limpiar las citas de la bbdd, porque si no al cerrar y abrir de nuevo almacenariamos repetidas
            repository.insertQuotes(quotes.map { it.toDatabase() })//insertar citas en la bbdd
            quotes
        }else{ //Si falla la llamada a la API, se cargan las citas desde la base de datos
            repository.getAllQuotesFromDatabase()
        }
    }


}
