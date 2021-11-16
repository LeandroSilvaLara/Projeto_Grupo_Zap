package br.com.leandro.grupozap.contract

import br.com.leandro.grupozap.viewmodel.Interactor
import br.com.leandro.grupozap.viewmodel.PropertieViewModel

enum class Configuration {

    INSTANCE;

    fun setCleanArchitecture(mainActivity: MainActivity) {
        val propertieViewModel = PropertieViewModel()
        propertieViewModel.mainActivity = mainActivity

        val interactor = Interactor()
        interactor.presenter = propertieViewModel
        mainActivity.interactor = interactor
    }
}