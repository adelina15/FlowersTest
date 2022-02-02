package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter: RecyclerView.Adapter<CatalogAdapter.CardsViewHolder>() {

    private var list = mutableListOf<BouquetCatalog>()

    fun setList(list: MutableList<BouquetCatalog>){
        this.list = list
        notifyDataSetChanged()
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardCatalogBinding.bind(item)
        fun bind(card:BouquetCatalog) = with(binding){
            ivBouquetCatalog.setImageResource(card.img)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_catalog, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogAdapter.CardsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}