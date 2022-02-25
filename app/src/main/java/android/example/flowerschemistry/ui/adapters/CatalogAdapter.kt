package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.utils.CatalogDiffUtil
import android.example.flowerschemistry.ui.utils.OnItemClickListenerCatalog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter(var list: ArrayList <BouquetCatalog>, val clickListener: OnItemClickListenerCatalog)
    : RecyclerView.Adapter<CatalogAdapter.CardsViewHolder>() {

    fun setList(newList: MutableList<BouquetCatalog>){
        val diffCallback = CatalogDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardCatalogBinding.bind(item)
        fun bind(card:BouquetCatalog, action:OnItemClickListenerCatalog) = with(binding){
            ivBouquetCatalog.setImageResource(card.img)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description_flowers
            tvPrice.text = card.price.toString()

            itemView.setOnClickListener{
                action.onItemClick(card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_catalog, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogAdapter.CardsViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
        /*holder.itemView.setOnClickListener {
            clickListener.onItemClick(list[position])
        }*/
    }

    override fun getItemCount(): Int {
        return list.size
    }
}