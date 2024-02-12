package com.patri.room_database.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.patri.room_database.data.database.dao.QuoteDao
import com.patri.room_database.data.database.entities.QuoteEntity


@Database(entities = [QuoteEntity::class], version = 1) //El 1 es un control de versiones, que ahora no se va a usar
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}
