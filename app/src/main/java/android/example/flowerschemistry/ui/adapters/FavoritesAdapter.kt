package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardFavoritesBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.utils.FavoritesDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter: RecyclerView.Adapter<FavoritesAdapter.MyViewHolder>(){

    private var list = mutableListOf<BouquetCatalog>()

    fun setList(newList: MutableList<BouquetCatalog>){
        val diffCallback = FavoritesDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }


    class MyViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemCardFavoritesBinding.bind(item)
        fun bind(item: BouquetCatalog) = with(binding){
            ivBouquetCatalog.setImageResource(item.img)
            tvBouquetName.text = item.name
            tvPrice.text = item.price.toString()
            tvBouquetDescription.text = item.description_flowers
            tvPrice.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_favorites, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesAdapter.MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}