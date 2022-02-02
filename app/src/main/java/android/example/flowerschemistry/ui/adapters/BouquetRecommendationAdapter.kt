package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardRecommendedBinding
import android.example.flowerschemistry.models.BouquetRecommendation
import android.example.flowerschemistry.ui.utils.RecommendationDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BouquetRecommendationAdapter: RecyclerView.Adapter<BouquetRecommendationAdapter.CardsViewHolder>() {

    private var list = mutableListOf<BouquetRecommendation>()

    fun setList(newList: MutableList<BouquetRecommendation>){
        val diffCallback = RecommendationDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardRecommendedBinding.bind(item)
        fun bind(card: BouquetRecommendation) = with(binding){
            ivBouquetRecommended1.setImageResource(card.img)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_recommended, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BouquetRecommendationAdapter.CardsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}