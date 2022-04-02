package android.example.flowerschemistry.ui.adapters

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.ItemCardThirdRowBinding
import android.example.flowerschemistry.data.models.Card
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardsThirdRowAdapter: RecyclerView.Adapter<CardsThirdRowAdapter.CardsViewHolder>() {

    private var list = mutableListOf<Card>()

    fun setList(list: MutableList<Card>){
        this.list = list
        notifyDataSetChanged()
    }

    class CardsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemCardThirdRowBinding.bind(item)
        fun bind(card: Card) = with(binding){
            ivCard.setImageResource(card.img)
            tvCard.text = card.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_third_row, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
