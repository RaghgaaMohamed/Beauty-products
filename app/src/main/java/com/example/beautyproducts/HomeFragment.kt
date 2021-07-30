package com.example.beautyproducts

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beautyproducts.databinding.FragmentHome1Binding

class HomeFragment : Fragment() {
    private var _binding: FragmentHome1Binding? = null
    private var imagesList = mutableListOf<Int>()
    lateinit var productsAdapter: ProductsAdapter
    var models = ArrayList<ModelProduct>()
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHome1Binding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postToList()

        binding.rvCategories.layoutManager = LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , false)
        binding.rvCategories.adapter = CategoryAdapter(imagesList)

        setUpViews()

    }

    private fun postToList() {
        imagesList.add(R.drawable.flat1)
        imagesList.add(R.drawable.flat2)
        imagesList.add(R.drawable.flat3)
        imagesList.add(R.drawable.flat4)
        imagesList.add(R.drawable.flat5)
        imagesList.add(R.drawable.flat6)

    }


    private fun setUpViews() {

        models.add(ModelProduct("Gentle Skin Cleanser","$12.29","300 Ml",R.drawable.a))
        models.add(ModelProduct("Eye Cream","$10.12","300 Ml",R.drawable.b))
        models.add(ModelProduct("Hand Cream","$12.29","300 Ml",R.drawable.c))
        models.add(ModelProduct("Bath Salts","$11.29","150 Ml",R.drawable.d))
        Log.e("model id",models.size.toString())
        productsAdapter= ProductsAdapter(models)
       binding.productsRecyclerview.adapter=productsAdapter

    }

}