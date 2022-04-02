package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardPopularBinding
import android.example.flowerschemistry.data.models.BouquetSelectionItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BouquetPopularAdapter: RecyclerView.Adapter<BouquetPopularAdapter.CardsViewHolder>() {

    private var list = mutableListOf<BouquetSelectionItem>()

    fun setList(newList: MutableList<BouquetSelectionItem>){
        this.list = newList
        notifyDataSetChanged()
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardPopularBinding.bind(item)
        fun bind(card: BouquetSelectionItem) = with(binding){
            Glide.with(itemView.context).load(card.image).into(ivBouquetPopular)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.cost.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_popular, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BouquetPopularAdapter.CardsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}