package android.example.flowerschemistry.ui.fragments


import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentBasketBinding

import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.adapters.BasketAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

class BasketFragment : Fragment() {
    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!
    private val adapterBasket by lazy { BasketAdapter() }

    private val itemListBasket by lazy {
        arrayListOf(
            BouquetCatalog(
                1,
                "Летний вечер",
                999,
                "Удивите кого-то особенным дизайном в оранжевых тонах, которые напоминают нежную кожицу. Розы, лилии, герберы, хризантемы и альстромерии составляют эту свежую ароматную композицию. Подойдет любительницам персиковых тонов!",
                "Розы, ромашки, лилии",
                R.drawable.image_slider3
            ),
            BouquetCatalog(
                2,
                "Робкая нежность",
                999,
                "Герберы – красочные солнечные цветочки, входят в топ самых популярных при составлении букетов. Они отлично смотрятся в разных сочетаниях и годятся абсолютно к каждому торжеству. Тем более что в срезанном виде они сохраняют свежесть до недели.",
                "Розы, ромашки, лилии",
                R.drawable.image_slider1
            ),
            BouquetCatalog(
                3,
                "Тайная мечта",
                999,
                "Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.",
                "Розы, ромашки, лилии",
                R.drawable.bouquet
            ),
            BouquetCatalog(
                4,
                "Тайная мечта",
                999,
                "Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.",
                "Розы, ромашки, лилии",
                R.drawable.bouquet
            ),
            BouquetCatalog(
                5,
                "Тайная мечта",
                999,
                "Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.",
                "Розы, ромашки, лилии",
                R.drawable.bouquet
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnGoToCatalog.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_basketFragment_to_catalogFragment)
        }

        setUpRecyclerViewBasket()

        return view

    }

    private fun setUpRecyclerViewBasket() {
        binding.ivBasket.visibility = View.GONE
        binding.tvTxt.visibility = View.GONE
        binding.btnGoToCatalog.visibility = View.GONE
        binding.rvBasketFull.visibility = View.VISIBLE
        binding.btnToOrder.visibility = View.VISIBLE
        binding.rvBasketFull.apply {
            adapter = adapterBasket
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        adapterBasket.setList(itemListBasket)
    }
}