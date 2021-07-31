package com.example.beautyproducts.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beautyproducts.data.repositories.ProductRepository

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}