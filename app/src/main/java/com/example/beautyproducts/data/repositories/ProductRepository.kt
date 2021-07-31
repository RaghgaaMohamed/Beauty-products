package com.example.beautyproducts.data.repositories

import androidx.lifecycle.LiveData
import com.example.beautyproducts.data.db.ProductDao
import com.example.beautyproducts.data.db.ProductDatabase
import com.example.beautyproducts.data.db.entities.Product

class ProductRepository(
    private val db: ProductDatabase
) {
    var readAllProducts : LiveData<List<Product>> = db.getProductDao().readAllProducts()
    suspend fun addProduct(product: Product) = db.getProductDao().addProduct(product)
    suspend fun deleteProduct(product: Product) = db.getProductDao().deleteProduct(product)
}