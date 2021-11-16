package br.com.leandro.grupozap.home.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.adapter.ImageAdapter
import br.com.leandro.grupozap.home.model.Building
import kotlinx.android.synthetic.main.activity_movel_recyclerview.*

class DetailsFragment : AppCompatActivity() {
    lateinit var rvImagens: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movel_recyclerview)
        findViews()
    }

    private fun findViews() {
        val building = intent.extras?.get("building") as Building

        rvImagens = imagens_buildin_activity
        rvImagens.adapter = ImageAdapter(building.images, this)

        num_values_building_activity.text =
            getString(R.string.formatacao_reais, building.pricingInfos.price.toFloat())
        num_bathroom_building_activity.text = building.bathrooms.toString()
        num_bedroom_building_activity.text = building.bedrooms.toString()
        num_vacancy_building_fragment.text = building.parkingSpaces.toString()
        num_square_meters_building_activity.text = building.usableAreas.toString()

        if (building.pricingInfos.businessType.equals("Sale"))
            item_BuildingType_activity.text = this.getString(R.string.property_type_sale)
        else
            item_BuildingType_activity.text = this.getString(R.string.property_type_rent)
    }
}