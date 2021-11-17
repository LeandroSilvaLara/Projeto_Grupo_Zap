package br.com.leandro.grupozap.viewmodel

import br.com.leandro.grupozap.contract.MainActivity
import br.com.leandro.grupozap.home.model.Building
import java.util.Locale.filter

class PropertieViewModel {

    lateinit var mainActivity: MainActivity
    lateinit var listVivaReal: ArrayList<Building>
    lateinit var listGrupZap: ArrayList<Building>
    var valSaleminimum: Double = 600000.0
    var valSaleMaximum: Double = 4000.0

    fun setVivaReal(buildings: List<Building>) {
        filter(buildings)
        mainActivity.startVivaReal(listVivaReal.toList())
    }

    fun  filter (buildings: List<Building>) {

    }


}