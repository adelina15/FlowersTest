package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardPopularBinding
import android.example.flowerschemistry.models.BouquetPopular
import android.example.flowerschemistry.ui.utils.PopularDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BouquetPopularAdapter: RecyclerView.Adapter<BouquetPopularAdapter.CardsViewHolder>() {

    private var list = mutableListOf<BouquetPopular>()

    fun setList(newList: MutableList<BouquetPopular>){
        val diffCallback = PopularDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardPopularBinding.bind(item)
        fun bind(card: BouquetPopular) = with(binding){
            ivBouquetPopular.setImageResource(card.img)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.price.toString()
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