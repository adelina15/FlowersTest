package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemYourOrderCompletedBinding
import android.example.flowerschemistry.models.YourOrder
import android.example.flowerschemistry.ui.utils.CompletedDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class OrdersCompletedAdapter: RecyclerView.Adapter<OrdersCompletedAdapter.OrdersCompletedViewHolder>() {

    private var list = mutableListOf<YourOrder>()
    fun setList(newList: MutableList<YourOrder>){
        val diffCallback = CompletedDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    class OrdersCompletedViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemYourOrderCompletedBinding.bind(item)
        fun bind(item: YourOrder) = with(binding){
            ivIcon.setImageResource(item.img)
            tvTitle.text = item.name
            tvPrice.text = item.price.toString()
            tvDate.text = item.date
            tvAddress.text = item.address
            tvStatus.text = item.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersCompletedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_order_completed, parent, false)
        return OrdersCompletedViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersCompletedViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return  list.size
    }

}