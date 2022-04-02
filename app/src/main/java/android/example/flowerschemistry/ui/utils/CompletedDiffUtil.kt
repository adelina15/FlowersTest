package android.example.flowerschemistry.ui.utils

import android.example.flowerschemistry.data.models.YourOrder
import androidx.recyclerview.widget.DiffUtil

class CompletedDiffUtil (
    private val oldList: List<YourOrder>,
    private val newList: List<YourOrder>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_ ,name, price) = oldList[oldItemPosition]
        val (_, new_name, new_price,) = newList[newItemPosition]
        return name == new_name && price == new_price
    }

}