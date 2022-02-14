package android.example.flowerschemistry.ui.fragments

import android.content.Intent
import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.AboutBouquet
import android.example.flowerschemistry.ui.adapters.CatalogAdapter
import android.example.flowerschemistry.ui.utils.OnItemClickListener
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager


class CatalogFragment : Fragment(), OnItemClickListener {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    private val itemListCatalog by lazy {
        arrayListOf(
            BouquetCatalog(1, "Летний вечер", 999,"Удивите кого-то особенным дизайном в оранжевых тонах, которые напоминают нежную кожицу. Розы, лилии, герберы, хризантемы и альстромерии составляют эту свежую ароматную композицию. Подойдет любительницам персиковых тонов!", "Розы, ромашки, лилии", R.drawable.image_slider3),
            BouquetCatalog(2, "Робкая нежность", 999,"Герберы – красочные солнечные цветочки, входят в топ самых популярных при составлении букетов. Они отлично смотрятся в разных сочетаниях и годятся абсолютно к каждому торжеству. Тем более что в срезанном виде они сохраняют свежесть до недели.", "Розы, ромашки, лилии", R.drawable.image_slider1),
            BouquetCatalog(3, "Тайная мечта", 999,"Фрезии — весенние цветы, имеют большое число оттенков. Существуют белые, желтые, красные, синие, багровые и фиолетовые разновидности. Букеты из фрезии – это символ полного доверия и благих намерений, отчего эти композиции, как правило, презентуют на помолвки или свадебные торжества.","Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(4, "Цветочный бал", 999,"Орхидеи - неизменные конкурентки лилий за место в свадебных букетах. Эти нежные цветы символизируют изысканность, нежность, естественную красоту и богатство. Букет из белых орхидей говорит о мудрости и невинности их хозяйки. Розовые поведают о нежности и шаловливом характере, красные – о безумной страсти, а синие — о преданности и великодушии.","Розы, ромашки, лилии", R.drawable.image_slider2),
            BouquetCatalog(5, "Настроение", 999,"Орхидеи - неизменные конкурентки лилий за место в свадебных букетах. Эти нежные цветы символизируют изысканность, нежность, естественную красоту и богатство. Букет из белых орхидей говорит о мудрости и невинности их хозяйки. Розовые поведают о нежности и шаловливом характере, красные – о безумной страсти, а синие — о преданности и великодушии.","Розы, ромашки, лилии", R.drawable.image_slider3)
        )
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvCatalog.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCatalog.adapter = CatalogAdapter(itemListCatalog, this)

        binding.slider.setLabelFormatter {
            getString(R.string.label_format, it)
        }


        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(item: BouquetCatalog) {
        /*Toast.makeText(requireContext(), item.name , Toast.LENGTH_SHORT).show()*/
        val intent = Intent(requireContext(), AboutBouquet::class.java)
        intent.putExtra("Name", item.name)
        intent.putExtra("Description", item.description)
        intent.putExtra("Image", item.img.toString())
        startActivity(intent)
    }
}