package br.com.leandro.grupozap.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.grupozap.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.imagens_itens.view.*

class ImageAdapter (val items: List<String>, val context: Context) :
        RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.imagens_itens,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(parent: ImageAdapter.ViewHolder, viewType: Int) {
        Glide.with(context).load(items.get(viewType)).into(parent?.ivBuildingImage);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivBuildingImage = view.photo_image_item
    }
}