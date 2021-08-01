package com.example.beautyproducts.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.beautyproducts.data.db.entities.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(product : Product)
    @Delete
    suspend fun deleteProduct(product : Product)
    @Query("SELECT * FROM products_db ")
    fun readAllProducts() : LiveData<List<Product>>
}