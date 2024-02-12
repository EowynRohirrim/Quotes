package com.patri.room_database.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton //solo hay un objeto
class QuoteProvider @Inject constructor(){
    //Al ser una clase inyectable ya es usable des cualquier parte, por eso quitamos el companion object

        var quotes:List<QuoteModel> = emptyList()

}
