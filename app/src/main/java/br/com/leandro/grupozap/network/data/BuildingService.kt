package br.com.leandro.grupozap.network.data

import br.com.leandro.grupozap.home.model.Building
import retrofit2.Call
import retrofit2.http.GET

interface BuildingService {
    @GET("source-1.json")
    fun list(): Call<List<Building>>
}