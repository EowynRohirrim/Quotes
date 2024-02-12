package com.patri.room_database.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.patri.room_database.data.database.entities.QuoteEntity


@Dao
interface QuoteDao {

    //Select se usa query
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes():List<QuoteEntity>

    //Para insertar se usa insert
    @Insert(onConflict = OnConflictStrategy.REPLACE) //onConflict si hay error de ids o citas iguales, entonces reemplaza
    suspend fun insertAll(quotes:List<QuoteEntity>) //objetos de la base de datos

    //Delete se usa query
    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()
}

