package com.example.beautyproducts.ui.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beautyproducts.data.db.ProductDao
import com.example.beautyproducts.data.db.ProductDatabase
import com.example.beautyproducts.data.db.entities.Product
import com.example.beautyproducts.data.repositories.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel(){

     val readAllProducts : LiveData<List<Product>> = repository.readAllProducts

    fun addProduct(product : Product){
        //using coroutines to run this function in background
        viewModelScope.launch(Dispatchers.IO) {
            repository.addProduct(product)
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProduct(product)

        }
    }
}
