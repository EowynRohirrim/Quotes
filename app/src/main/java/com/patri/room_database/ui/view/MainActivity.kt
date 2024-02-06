package com.patri.room_database.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.patri.room_database.databinding.ActivityMainBinding
import com.patri.room_database.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()//by -> Esto hace que sea un objeto único @singleton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()


        quoteViewModel.quoteModel.observe(this, Observer { //observe va estar mirando continuamente el valor que tiene
            //Podemos poner nombre a it justo después de "{", por ejemplo, "currentQuote ->"
            binding.tvQuote.text = it.quote //asigna la cita //Revisar it?
            binding.tvAuthor.text = it.author //asigna el autor
        })

        //Va a estar observando si está cargando o no desde QuoteViewModel
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }


    }
}