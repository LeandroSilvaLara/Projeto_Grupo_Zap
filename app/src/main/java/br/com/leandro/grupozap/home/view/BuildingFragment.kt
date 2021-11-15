package br.com.leandro.grupozap.home.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.home.model.Building
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

class BuildingFragment (val items: List<Building>, val context: Context, val clickListener: (Building) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BuildingViewHolder).bind(items[position], clickListener)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class BuildingViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemViw = view
        fun bind(part: Building, clickListener: (Building) -> Unit){
            if (part.pricingInfos.businessType.equals("SALE")){
                itemViw.rental_building_fragment.text =
                    itemViw.context.getString(R.string.property_type_sale)
            } else
                itemViw.rental_building_fragment.text =
                    itemViw.context.getText(R.string.property_type_rent)

            itemViw.num_bedroom_building_fragment.text = part.bedrooms.toString()
            itemViw.num_bathroom_building_fragment.text = part.bathrooms.toString()
            itemViw.num_vacancy_building_fragment.text = part.parkingSpaces.toString()
            itemViw.num_square_meters_building_fragment.text = part.usableAreas.toString()
            itemViw.num_values_building_fragment.text =
                itemViw.context.getString(R.string.formatacao_reais, part.pricingInfos.price.toFloat())


            Glide.with(itemView.context).load(part.images.get(0)).into(itemViw.imagens_fragment);

            val layout: CardView = itemViw.card_building_fragment
            val animZoomin = AnimationUtils.loadAnimation(
                itemViw.context,
                R.anim.ani_zooming
            )
            val x = 200 * adapterPosition
            animZoomin.startOffset = x.toLong()
            layout.setAnimation(animZoomin)

            itemViw.setOnClickListener { clickListener(part) }

        }


    }

}