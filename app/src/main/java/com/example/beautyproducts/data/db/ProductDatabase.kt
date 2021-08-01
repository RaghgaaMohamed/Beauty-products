package com.example.beautyproducts.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.beautyproducts.data.db.entities.Product


private const val DATABASE_NAME = "products_database"

@Database(entities = [Product::class], version = 1, exportSchema = false)


abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao


    companion object {

        @Volatile
        private var instance: ProductDatabase? = null
//        private var varLock = Any()

        //invoke means that this fun id executed whenever we created database instance of shoppingDatabase class

        operator fun invoke(context: Context): ProductDatabase {

            return instance ?: synchronized(Any()) {

                instance ?: createDatabase(context).also { instance = it }


            }
        }


        private fun createDatabase(context: Context): ProductDatabase {

            return Room.databaseBuilder(
                context.applicationContext, ProductDatabase::class.java,
                DATABASE_NAME

            ).build()


        }
    }

}

