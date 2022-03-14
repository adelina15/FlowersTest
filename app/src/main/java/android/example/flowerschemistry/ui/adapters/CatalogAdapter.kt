package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalogItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CatalogAdapter: RecyclerView.Adapter<CatalogAdapter.CardsViewHolder>() {

    var listCatalog = mutableListOf<BouquetCatalogItem>()

    fun setData(newList: List<BouquetCatalogItem>){
        listCatalog = newList.toMutableList()
        notifyDataSetChanged()
    }

    /*fun setList(newList: MutableList<BouquetCatalogItem>){
        val diffCallback = CatalogDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }*/

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardCatalogBinding.bind(item)
        fun bind(card:BouquetCatalogItem) = with(binding){
            Glide.with(itemView.context).load(card.image).into(ivBouquetCatalog)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.cost.toString()

            //itemView.setOnClickListener{
           //     action.onItemClick(card)
           // }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_catalog, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogAdapter.CardsViewHolder, position: Int) {
        holder.bind(listCatalog[position])
        /*holder.itemView.setOnClickListener {
            clickListener.onItemClick(list[position])
        }*/
    }

    override fun getItemCount(): Int {
        return listCatalog.size
    }
}