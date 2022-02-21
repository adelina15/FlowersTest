package android.example.flowerschemistry.ui.fragments


import android.content.Intent
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentFavoritesBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.AuthorizationPhoneActivity
import android.example.flowerschemistry.ui.adapters.FavoritesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager


class FavoritesFragment : Fragment() {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private val adapterFavorites by lazy{ FavoritesAdapter() }

    private val itemListFavorites by lazy {
        arrayListOf(
            BouquetCatalog(1, "Летний вечер", 999,"Удивите кого-то особенным дизайном в оранжевых тонах, которые напоминают нежную кожицу. Розы, лилии, герберы, хризантемы и альстромерии составляют эту свежую ароматную композицию. Подойдет любительницам персиковых тонов!", "Розы, ромашки, лилии", R.drawable.image_slider3),
            BouquetCatalog(2, "Робкая нежность", 999,"Герберы – красочные солнечные цветочки, входят в топ самых популярных при составлении букетов. Они отлично смотрятся в разных сочетаниях и годятся абсолютно к каждому торжеству. Тем более что в срезанном виде они сохраняют свежесть до недели.", "Розы, ромашки, лилии", R.drawable.image_slider1),
            BouquetCatalog(3, "Тайная мечта", 999,"Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.","Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(4, "Тайная мечта", 999,"Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.","Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(3, "Тайная мечта", 999,"Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.","Розы, ромашки, лилии", R.drawable.bouquet)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnGoToCatalog.setOnClickListener { Navigation.findNavController(view)
            .navigate(R.id.action_favoritesFragment_to_catalogFragment) }

        setUpRecyclerViewFavorites()
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //AlertDialog для авторизации
        val builder = AlertDialog.Builder(requireContext(),R.style.CustomAlertDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.customview_layout,null)
        val buttonAuth = view.findViewById<Button>(R.id.btn_authorization)
        val buttonSkip = view.findViewById<Button>(R.id.btn_skip)
        builder.setView(view)
        buttonAuth.setOnClickListener {
            val intent = Intent(requireContext(), AuthorizationPhoneActivity::class.java)
            startActivity(intent)
        }

        buttonSkip.setOnClickListener {
            builder.dismiss()
        }

        builder.setCanceledOnTouchOutside(false)
        builder.show()
    }

    private fun  setUpRecyclerViewFavorites() {
        binding.imFavorites.visibility = View.GONE
        binding.tvTxt.visibility = View.GONE
        binding.btnGoToCatalog.visibility = View.GONE
        binding.rvFavoritesFull.visibility = View.VISIBLE
        binding.rvFavoritesFull.apply {
            adapter = adapterFavorites
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        adapterFavorites.setList(itemListFavorites)
    }
}