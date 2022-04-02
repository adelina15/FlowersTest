package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemToOrderBinding
import android.example.flowerschemistry.data.models.ToOrder
import android.example.flowerschemistry.ui.utils.ToOrderDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ToOrderAdapter: RecyclerView.Adapter<ToOrderAdapter.OrderViewHolder>() {

    private var list = mutableListOf<ToOrder>()

    fun setList(newList: MutableList<ToOrder>){
        val diffCallback = ToOrderDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }


    class OrderViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding =ItemToOrderBinding.bind(item)
        fun bind(item: ToOrder) = with(binding){
            ivIcon.setImageResource(item.img)
            tvTitle.text = item.name
            tvPrice.text = item.price.toString()
            tvQuantity.text = item.quantity.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_to_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}