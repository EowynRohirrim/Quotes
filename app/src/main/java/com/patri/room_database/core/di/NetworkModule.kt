package com.patri.room_database.core.di

import com.patri.room_database.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent //Alcance de la aplicación
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module  //modulo de hilt
@InstallIn(SingletonComponent::class) //Alcance de aplicación, clase de hilt
object NetworkModule {

    @Singleton //Solo permite una instancia de Retrofit para no consumir memoria
    @Provides //proveer una clase, cojo una app que no es de la app y proveo a mi app
    fun provideRetrofit(): Retrofit { //Lo hacemos singleton para que solo se puede instanciar una vez
        return Retrofit.Builder()
            .baseUrl("https://acceso-a-bd-androidstudio-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient { //proveeme la interfaz de acceso a la api
        return retrofit.create(QuoteApiClient::class.java)
    }

}
