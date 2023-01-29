package kz.lesa.drawerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.lesa.drawerapp.databinding.ArtItemBinding

class ArtAdapter : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {
    val artList = ArrayList<Art>()

    class ArtHolder (item: View) : RecyclerView.ViewHolder (item){
        val binding = ArtItemBinding.bind(item)
        fun bind(art: Art) = with(binding){
            im.setImageResource(art.imageId)
            tvTitle.text = art.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.art_item, parent, false)
        return ArtHolder(view)
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.bind(artList [position])
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    fun addArt(art: Art){
        artList.add(art)
        notifyDataSetChanged()
    }
}