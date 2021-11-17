package br.com.leandro.grupozap.viewmodel

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.adapter.BuildingActivity
import br.com.leandro.grupozap.home.model.Building
import br.com.leandro.grupozap.home.view.BuildingFragment
import kotlinx.android.synthetic.main.zap_catalog_activity.*
import java.io.Serializable

class VivaRealActivity : AppCompatActivity() {
    lateinit var editBuildings: RecyclerView
    lateinit var listImoveis: List<Building>
    lateinit var btnVermais: Button
    var contador = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viva_real_catalog_activity)

        findViews()
        setRecycler()
    }

    private fun setRecycler() {
        editBuildings.adapter = BuildingFragment(listImoveis, this, { partItem: Building -> partItemClicked(partItem) })

    }



    private fun partItemClicked(imovel: Building) {
        val intent: Intent = Intent (this, BuildingActivity::class.java)
        intent.putExtra("building", imovel as Serializable)
        startActivity(intent)
    }

    private fun findViews() {
        val buildings = intent.extras?.get("buildings_zap") as List<Building>
        listImoveis = buildings.take(contador)
        editBuildings = grupozap_list_imoveeis

        btnVermais = btn_proximo
        btnVermais.setOnClickListener {
            contador = contador + 20
            listImoveis = buildings.take(contador)
            setRecycler()
        }
    }
}