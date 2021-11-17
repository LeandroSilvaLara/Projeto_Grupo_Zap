package br.com.leandro.grupozap.contract

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageButton
import android.widget.ProgressBar
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.home.model.Building
import br.com.leandro.grupozap.viewmodel.Interactor
import br.com.leandro.grupozap.viewmodel.VivaRealActivity
import br.com.leandro.grupozap.viewmodel.ZapActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var tilVivaReal: ImageButton
    lateinit var tilZap: ImageButton
    lateinit var interactor: Interactor
    lateinit var tilLoading: ProgressBar

    val grupZap = 1
    val vivaReal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_Grupozap)

        setContentView(R.layout.activity_main)

        Configuration.INSTANCE.setCleanArchitecture(this)

        findViews()
    }

    private fun findViews() {
        tilVivaReal = btn_vivareal
        tilZap = btn_zap
        tilLoading = progressBar

        tilVivaReal.setOnClickListener {
            tilLoading.visibility = VISIBLE
            interactor.fetch(vivaReal)
        }

        tilZap.setOnClickListener {
            tilLoading.visibility = VISIBLE
            interactor.fetch(grupZap)
        }

    }

    fun startVivaReal(buildings: List<Building>) {
        tilLoading.visibility = GONE
        val intent: Intent = Intent(this, VivaRealActivity::class.java)
        intent.putExtra("buildings_vivareal", buildings as Serializable)
        startActivity(intent)
    }

    fun startGrupZap (buildings: List<Building>) {
        tilLoading.visibility = GONE
        val intent: Intent = Intent(this, ZapActivity::class.java)
        intent.putExtra("building_zap", buildings as Serializable)
        startActivity(intent)
    }
}