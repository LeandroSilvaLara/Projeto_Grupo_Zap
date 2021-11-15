package br.com.leandro.grupozap.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.contract.MainListView

class ListActivity : AppCompatActivity(), MainListView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)


    }

    override fun onStart() {
        super.onStart()

    }

    override fun isAdded(): Boolean {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun hideError() {
        TODO("Not yet implemented")
    }

    override fun showFilter() {
        TODO("Not yet implemented")
    }

    override fun hideFilter() {
        TODO("Not yet implemented")
    }

    override fun setTitle(title: String) {
        TODO("Not yet implemented")
    }

    override fun hideCloseFilter() {
        TODO("Not yet implemented")
    }

    override fun showCloseFilter() {
        TODO("Not yet implemented")
    }
}