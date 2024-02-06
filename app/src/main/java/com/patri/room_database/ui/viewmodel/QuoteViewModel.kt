package com.patri.room_database.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patri.room_database.data.model.QuoteModel
import com.patri.room_database.data.model.QuoteProvider
import com.patri.room_database.domain.GetQuotesUseCase
import com.patri.room_database.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
)  : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()//Librería LiveData mira si el elemento cambia

    val isLoading = MutableLiveData<Boolean>() //Valor para la progressbar


    fun randomQuote() {
        //val currentQuote: QuoteModel = QuoteProvider.random()
       // quoteModel.postValue(currentQuote)

        isLoading.postValue(true) //muestra progressbar
        val quote = getRandomQuoteUseCase()//metodo de la otra clase, devuelve una cita aleatoria
        if(quote!=null) {
            quoteModel.postValue(quote) //Asigno la cita al objeto quoteModel
        }
        isLoading.postValue(false)//oculta la progressbar
    }

    //Se ejecuta una vez cuando se arranca la app
    fun onCreate() {
        isLoading.postValue(true)

        viewModelScope.launch {
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {//si el resultado no es nulo o vacio...
                quoteModel.postValue(result[0])//le damos la primera cita
                isLoading.postValue(false)

            }
        }


    }



}
