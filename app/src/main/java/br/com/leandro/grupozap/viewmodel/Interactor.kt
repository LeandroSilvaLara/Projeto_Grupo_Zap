package br.com.leandro.grupozap.viewmodel

import retrofit2.Retrofit

class Interactor{
    lateinit var presenter: PropertieViewModel

    fun fetch(int: Int){
        val call = RetrofitInitializer()
    }
}
