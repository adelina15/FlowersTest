package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.databinding.FragmentCatalogBinding
import android.example.flowerschemistry.models.BouquetCatalogItemItem
import android.example.flowerschemistry.ui.adapters.CatalogAdapter
import android.example.flowerschemistry.ui.utils.OnItemClickListenerCatalog
import android.example.flowerschemistry.viewmodel.CatalogViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel

class CatalogFragment : Fragment(), OnItemClickListenerCatalog {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val catalogViewModel by viewModel<CatalogViewModel>()
    private val catalogAdapter by lazy { CatalogAdapter(this@CatalogFragment) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.slider.setLabelFormatter {
            getString(R.string.label_format, it)
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(catalogViewModel)
        setupRecyclerViewCatalog()
        showProgressBar()
        catalogViewModel.catalogLiveData.observe(viewLifecycleOwner){
            catalogAdapter.setData(it.toList())
            hideProgressBar()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun setupRecyclerViewCatalog(){
        binding.rvCatalog.apply {
            adapter = catalogAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onItemClick(item: BouquetCatalogItemItem) {
        findNavController().navigate(R.id.action_catalogFragment_to_bouquetFragment)
    }
}
