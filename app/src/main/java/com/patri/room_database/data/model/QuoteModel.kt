package com.patri.room_database.data.model

import com.google.gson.annotations.SerializedName


/**Trabaja con los datos que vienen del servidor */
data class QuoteModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
    )

