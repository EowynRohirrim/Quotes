package com.patri.room_database.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class QuoteEntity(//Como crear una tabla en SQL
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0, //el primer registro que mete es cero (estilo lista)
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String

    //ColumInfo le pasamos el nombre de la columna
    //Tabla de tres campos
)
