package br.com.leandro.grupozap.viewmodel

import br.com.leandro.grupozap.contract.MainActivity
import br.com.leandro.grupozap.home.model.Building
import br.com.leandro.grupozap.utils.Lat_LonUtils
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

    fun setZap(buildings: List<Building>){
        filter(buildings)
        mainActivity.startGrupZap(listGrupZap.toList())
    }

    fun  filter (buildings: List<Building>) {
        listVivaReal = ArrayList()
        listGrupZap = ArrayList()
        for (i in buildings ) {
            if (i.address.geoLocation.location.lat != 0.0 && i.address.geoLocation.location.lon != 0.0 && i.pricingInfos.monthlyCondoFee != null && i.usableAreas > 0) {
                if (i.pricingInfos.businessType == "SALE") {
                    if (Lat_LonUtils.calcular(
                            i.address.geoLocation.location.lat,
                            i.address.geoLocation.location.lon
                        )
                    )
                        valSaleminimum = valSaleminimum - (0.1 * valSaleminimum)

                    if (i.pricingInfos.price.toDouble() <= 700000.0) {
                        listVivaReal.add(i)
                    }
                    if ((i.pricingInfos.price.toDouble() / i.usableAreas > 3500.0) && i.pricingInfos.price.toDouble() >= valSaleminimum) {
                        listGrupZap.add(i)
                    }
                    valSaleminimum = 600000.0

                }else {
                    if (Lat_LonUtils.calcular(
                         i.address.geoLocation.location.lat,
                         i.address.geoLocation.location.lon
                        )
                    )
                        valSaleMaximum = valSaleMaximum + (0.5 * valSaleMaximum)
                    if (i.pricingInfos.monthlyCondoFee.toDouble() >= (0.3 * i.pricingInfos.price.toDouble()) && i.pricingInfos.rentalTotalPrice.toDouble() <= valSaleMaximum) {
                        listVivaReal.add(i)
                    }
                    if (i.pricingInfos.rentalTotalPrice.toDouble() >= 3500.0) {
                        listGrupZap.add(i)
                    }
                    valSaleMaximum = 4000.0
                }
            }
        }
    }
}


