package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalog
import android.example.flowerschemistry.ui.adapters.CatalogAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager


class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val adapterCatalog by lazy { CatalogAdapter() }

    private val itemListCatalog by lazy {
        mutableListOf(
            BouquetCatalog(1, "Букет осенний блюз", 999,"Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(2, "Букет осенний блюз", 999,"Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(3, "Букет осенний блюз", 999,"Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(4, "Букет осенний блюз", 999,"Розы, ромашки, лилии", R.drawable.bouquet),
            BouquetCatalog(5, "Букет осенний блюз", 999,"Розы, ромашки, лилии", R.drawable.bouquet)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rvCatalog.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvCatalog.adapter = adapterCatalog
        adapterCatalog.setList(itemListCatalog)

        binding.slider.setLabelFormatter {
            getString(R.string.label_format, it)
        }

        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}