package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardBasketBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.utils.BasketDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class BasketAdapter: RecyclerView.Adapter<BasketAdapter.MyViewHolder>() {

    private var list = mutableListOf<BouquetCatalog>()

    fun setList(newList: MutableList<BouquetCatalog>){
        val diffCallback = BasketDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder (item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemCardBasketBinding.bind(item)
        fun bind(item: BouquetCatalog) = with(binding){
            ivBouquetCatalog.setImageResource(item.img)
            tvBouquetName.text = item.name
            tvPrice.text = item.price.toString()
            tvBouquetDescription.text = item.description_flowers
            tvPrice.text = item.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_basket, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}