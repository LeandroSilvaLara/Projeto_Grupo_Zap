package br.com.leandro.grupozap.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.home.model.Building
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

class BuildingAdapter (val items: List<Building>, val context: Context, val clickListener: (Building) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BuildingViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_detail, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       ( holder as BuildingViewHolder).bind(items[position], clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BuildingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemView = view
        fun bind (part: Building, clickListener: (Building) -> Unit) {
            if (part.pricingInfos.businessType.equals("SALE")) {
                itemView.rental_building_fragment.text =
                    itemView.context.getString(R.string.property_type_sale)
            } else
                itemView.rental_building_fragment.text =
                    itemView.context.getString(R.string.property_type_rent)

            itemView.num_bedroom_building_fragment.text = part.bedrooms.toString()
            itemView.num_bathroom_building_fragment.text = part.bathrooms.toString()
            itemView.num_vacancy_building_fragment.text = part.parkingSpaces.toString()
            itemView.num_square_meters_building_fragment.text = part.usableAreas.toString()
            itemView.num_values_building_fragment.text =
                itemView.context.getString(R.string.formatacao_reais, part.pricingInfos.price.toFloat())

            Glide.with(itemView.context).load(part.images.get(0)).into(itemView.imagens_fragment)

            val layout: CardView = itemView.card_building_fragment
            val animZoomin = AnimationUtils.loadAnimation(
                itemView.context,
                R.anim.ani_zooming
            )
            val i = 200 * adapterPosition
            animZoomin.startOffset = i.toLong()
            layout.setAnimation(animZoomin)

            itemView.setOnClickListener { clickListener(part) }
        }
    }

}
