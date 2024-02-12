package com.patri.room_database.data.di

import android.content.Context
import androidx.room.Room
import com.patri.room_database.data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //installin tiene alcance a toda la app
object RoomModule {
    private const val QUOTE_DATABASE_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build() //Constructor de room
    @Singleton   @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()


}
