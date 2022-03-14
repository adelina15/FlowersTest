package android.example.flowerschemistry.viewmodel

import android.example.flowerschemistry.repository.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CatalogViewModelFactory (private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatalogViewModel(repository) as T
    }

}