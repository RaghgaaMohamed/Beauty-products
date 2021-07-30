package com.example.beautyproducts.data

import androidx.lifecycle.LiveData
import com.example.beautyproducts.data.db.ProductDao
import com.example.beautyproducts.data.db.entities.Product

class ProductRepository(
    private val productDao: ProductDao
) {
    var readAllProducts : LiveData<List<Product>> = productDao.readAllProducts()
    suspend fun addProduct(product: Product) = productDao.addProduct(product)
    suspend fun deleteProduct(product: Product) = productDao.deleteProduct(product)
}