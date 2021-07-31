package com.example.beautyproducts.adapters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelProduct( val name:String,
                         val price:String,
                         val size:String,
                         val images:Int
) : Parcelable