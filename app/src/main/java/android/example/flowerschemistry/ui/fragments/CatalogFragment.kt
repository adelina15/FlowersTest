package android.example.flowerschemistry.ui.fragments

import android.example.flowerschemistry.R
import android.example.flowerschemistry.api.RetrofitInstance
import android.example.flowerschemistry.databinding.FragmentCatalogBinding
import android.example.flowerschemistry.repository.Repository
import android.example.flowerschemistry.ui.adapters.CatalogAdapter
import android.example.flowerschemistry.viewmodel.CatalogViewModel
import android.example.flowerschemistry.viewmodel.CatalogViewModelFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager


class CatalogFragment : Fragment() {
    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!
    private val retrofitService = RetrofitInstance.api
    lateinit var viewModel: CatalogViewModel
    lateinit var catalogAdapter: CatalogAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.slider.setLabelFormatter {
            getString(R.string.label_format, it)
        }

        viewModel = ViewModelProvider(this, CatalogViewModelFactory(Repository(retrofitService)))
            .get(CatalogViewModel::class.java)

        setupRecyclerViewCatalog()
        viewModel.catalogResponse.observe(viewLifecycleOwner, {
            showProgressBar()
            catalogAdapter.setData(it)
            hideProgressBar()
        })
        viewModel.getCatalog()


        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

   /* override fun onItemClick(item: BouquetCatalogItem) {
        findNavController().navigate(R.id.action_catalogFragment_to_bouquetFragment)

        /*val intent = Intent(requireContext(), AboutBouquet::class.java)
        intent.putExtra("Name", item.name)
        intent.putExtra("Description", item.description)
        intent.putExtra("Image", item.img.toString())
        startActivity(intent)*/
    }*/

    private fun setupRecyclerViewCatalog(){
        catalogAdapter = CatalogAdapter()
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
}
