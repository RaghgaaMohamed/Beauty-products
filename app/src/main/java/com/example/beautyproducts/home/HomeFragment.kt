package com.example.beautyproducts.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.beautyproducts.R
import com.example.beautyproducts.adapter.Products_Adapter
import com.example.beautyproducts.modelproduct
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


class HomeFragment : Fragment() {
     lateinit var productsAdapter: Products_Adapter
     var models = ArrayList<modelproduct>()

override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setUpViews()
    }


    private fun setUpViews() {

        models.add(modelproduct("Gentle Skin Cleanser","$12.29","300 Ml",R.drawable.a))
        models.add(modelproduct("Eye Cream","$10.12","300 Ml",R.drawable.b))
        models.add(modelproduct("Hand Cream","$12.29","300 Ml",R.drawable.c))
        models.add(modelproduct("Bath Salts","$11.29","150 Ml",R.drawable.d))
        Log.e("model id",models.size.toString())
        productsAdapter= Products_Adapter(models)
        products_recyclerview.adapter=productsAdapter

    }



}