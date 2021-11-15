package br.com.leandro.grupozap.contract

interface MainListView {

    fun isAdded(): Boolean
   // fun loadList(list: List<Imovel>)
    fun showProgress()
    fun hideProgress()
    fun showError()
    fun hideError()
    fun showFilter()
    fun hideFilter()
    fun setTitle(title: String)
    fun hideCloseFilter()
    fun showCloseFilter()
}