package br.com.leandro.grupozap.viewmodel

import br.com.leandro.grupozap.home.model.Building
import br.com.leandro.grupozap.network.data.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Interactor{
    lateinit var presenter: PropertieViewModel

    fun fetch(int: Int){
        val call = RetrofitInitializer().buildingService().list()
        call.enqueue(object : Callback<List<Building>?>{
            override fun onResponse(
                call: Call<List<Building>?>,
                response: Response<List<Building>?>
            ) {
                response?.body()?.let {
                    val imoveis: List<Building> = it
                    if (int == 0)
                        presenter.setVivaReal(imoveis)
                    else
                        presenter.setZ
                }
            }
        })
    }
}
