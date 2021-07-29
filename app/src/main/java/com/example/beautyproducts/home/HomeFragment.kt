package com.example.beautyproducts.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import com.example.beautyproducts.R
import com.example.beautyproducts.adapter.CategoryAdapter
import com.example.beautyproducts.adapter.Products_Adapter
import com.example.beautyproducts.databinding.ActivityMainBinding
import com.example.beautyproducts.databinding.FragmentHomeBinding
import com.example.beautyproducts.modelproduct
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*
import java.util.Collections.list


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var imagesList = ArrayList<Int>()
    val tab_items=ArrayList<String>()

     var models = ArrayList<modelproduct>()

override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentHomeBinding.inflate(inflater,container,false)
       val view =binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setUpViews()
    }

    private fun postToList() {

        tab_items.add("Skin")
        tab_items.add("Hair")
        tab_items.add("Personal Care")
        tab_items.add("Other")

        imagesList.add(R.drawable.flat1)
        imagesList.add(R.drawable.flat2)
        imagesList.add(R.drawable.flat3)
        imagesList.add(R.drawable.flat4)
        imagesList.add(R.drawable.flat5)
        imagesList.add(R.drawable.flat6)

        models.add(modelproduct("Gentle Skin Cleanser","$12.29","300Ml",R.drawable.a))
        models.add(modelproduct("Eye Cream","$10.12","300Ml",R.drawable.b))
        models.add(modelproduct("Hand Cream","$12.29","300Ml",R.drawable.c))
        models.add(modelproduct("Bath Salts","$11.29","150Ml",R.drawable.d))
    }

    private fun setUpViews() {
        postToList()
        binding.productsRecyclerview.adapter = Products_Adapter(models)
        binding.rvCategories.adapter = CategoryAdapter(imagesList)
        for (i in 0..tab_items.size-1) {
            val tab = binding.tabLayout.newTab()
            tab.setText(tab_items.get(i))
            binding.tabLayout.addTab(tab)
        }
    }


}