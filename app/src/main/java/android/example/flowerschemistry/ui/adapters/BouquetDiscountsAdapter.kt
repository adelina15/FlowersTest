package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardDiscountsBinding
import android.example.flowerschemistry.models.BouquetDiscounts
import android.example.flowerschemistry.ui.utils.DiscountsDiffUtil
import android.example.flowerschemistry.ui.utils.RecommendationDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BouquetDiscountsAdapter : RecyclerView.Adapter<BouquetDiscountsAdapter.CardsViewHolder>() {

    private var list = mutableListOf<BouquetDiscounts>()

    fun setList(newList: MutableList<BouquetDiscounts>){
        val diffCallback = DiscountsDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardDiscountsBinding.bind(item)
        fun bind(card: BouquetDiscounts) = with(binding){
            ivBouquetDiscounts.setImageResource(card.img)
            tvBouquetName.text = card.name
            tvBouquetDescription.text = card.description
            tvPrice.text = card.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_discounts, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BouquetDiscountsAdapter.CardsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}