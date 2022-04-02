package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemYourOrderActiveBinding
import android.example.flowerschemistry.data.models.YourOrder
import android.example.flowerschemistry.ui.utils.OrdersActiveDiffUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class OrdersActiveAdapter: RecyclerView.Adapter<OrdersActiveAdapter.OrdersActiveViewHolder>() {

    var list = ArrayList <YourOrder>()
    fun setList(newList: MutableList<YourOrder>){
        val diffCallback = OrdersActiveDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }


    class OrdersActiveViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemYourOrderActiveBinding.bind(item)
        fun bind(item: YourOrder) = with(binding){
            ivIcon.setImageResource(item.img)
            tvTitle.text = item.name
            tvPrice.text = item.price.toString()
            tvDate.text = item.date
            tvAddress.text = item.address


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersActiveViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_order_active, parent, false)
        return OrdersActiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersActiveViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }
}