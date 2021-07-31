package com.example.beautyproducts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beautyproducts.R
import com.example.beautyproducts.adapters.CategoryAdapter
import com.example.beautyproducts.adapters.ModelProduct
import com.example.beautyproducts.adapters.OnItemClickListener
import com.example.beautyproducts.adapters.ProductsAdapter
import com.example.beautyproducts.databinding.FragmentHome1Binding

class HomeFragment : Fragment() , OnItemClickListener {
    private var _binding: FragmentHome1Binding? = null
    private val binding get() = _binding!!

    private var imagesList = mutableListOf<Int>()
    lateinit var productsAdapter: ProductsAdapter
    val tab_items = ArrayList<String>()
    var models = ArrayList<ModelProduct>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHome1Binding.inflate(layoutInflater)
        val view = binding.root
        setUpViews()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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

        models.add(ModelProduct("Gentle Skin Cleanser", "12.29", "300", R.drawable.a))
        models.add(ModelProduct("Eye Cream", "10.12", "300", R.drawable.b))
        models.add(ModelProduct("Hand Cream", "12.29", "300", R.drawable.c))
        models.add(ModelProduct("Bath Salts", "11.29", "150", R.drawable.d))
    }

    private fun setUpViews() {
        postToList()
        binding.productsRecyclerview.adapter = ProductsAdapter(models , this)
        binding.rvCategories.adapter = CategoryAdapter(imagesList)

        binding.rvCategories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = CategoryAdapter(imagesList)

        for (i in 0..tab_items.size - 1) {
            val tab = binding.tabLayout.newTab()
            tab.setText(tab_items.get(i))
            binding.tabLayout.addTab(tab)
        }

        //adapter
        productsAdapter = ProductsAdapter(models ,this )
    }

    override fun onItemClick(position: Int, modelProduct: ModelProduct) {
        Toast.makeText(context , " hi" , Toast.LENGTH_LONG).show()
        val action = HomeFragmentDirections.actionHomeFragmentToProductFragment(modelProduct)
        findNavController().navigate(action)

    }
}