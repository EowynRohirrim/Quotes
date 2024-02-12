package com.patri.room_database.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patri.room_database.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(// Es como crear una tabla en SQL

    //Clave primaria
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0, //el primer registro que mete es cero (estilo lista)
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String

    //ColumInfo le pasamos el nombre de la columna
    //Tabla de tres campos
)


// Hay que especificarle los campos porque también existe el campo "id"
fun Quote.toDatabase() = QuoteEntity(quote = quote, author =  author)
//Coge de Quote, quote y author
/**como son dos y en realidad son tres hay que indicarle donde guardarlos por eso sale quote = quote y así*/
