package com.patri.room_database.domain.model

import com.patri.room_database.data.database.entities.QuoteEntity
import com.patri.room_database.data.model.QuoteModel


/**Estamos conviertiendo daots de una clase a datos de otra clase*/
data class Quote (val quote:String, val author:String)
// Los mapper se declaran en la clase final donde queremos heredar
fun QuoteModel.toDomain() = Quote(quote, author)    //Quote hereda los atributos quote y author de QuoteModel
fun QuoteEntity.toDomain() = Quote(quote, author)
