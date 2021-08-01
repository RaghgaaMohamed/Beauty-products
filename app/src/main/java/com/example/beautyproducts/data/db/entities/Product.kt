package com.example.beautyproducts.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "products_db")
data class Product(
    @ColumnInfo(name = "product_name")
    var name : String ,
    @ColumnInfo(name = "product_price")
    var price : Double ,
    @ColumnInfo(name = "product_size")
    var size : Int ,
    @ColumnInfo(name = "product_number")
    var number : Int
){
    @PrimaryKey(autoGenerate = true )
    var id :Int ? = null
}