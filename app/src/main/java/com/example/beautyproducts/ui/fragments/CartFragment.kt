package com.example.beautyproducts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beautyproducts.R
import com.example.beautyproducts.adapters.CartAdapter
import com.example.beautyproducts.data.db.ProductDatabase
import com.example.beautyproducts.data.repositories.ProductRepository
import com.example.beautyproducts.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    //view binding
    private var _binding : FragmentCartBinding? = null
    private val binding get() = _binding!!

    //view model
    private lateinit var productViewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(layoutInflater)
        val view = binding.root

        //adapter
        val adapter = CartAdapter()
        //recyclerView
        val recyclerView = binding.rvCart
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //productViewModel
        val mDb = ProductDatabase(requireContext())

        //repository
        val mRepository = ProductRepository(mDb)

        //factory
        val factory = ProductViewModelFactory(mRepository)

        //view model object
        val productViewModel = ViewModelProviders.of(this, factory).get(ProductViewModel::class.java)
        productViewModel.readAllProducts.observe(viewLifecycleOwner , Observer { product ->
            adapter.setData(product)
        })

        binding.contiueBtn.setOnClickListener {
            val action = CartFragmentDirections.actionCartFragmentToHomeFragment()
            findNavController().navigate(action)

        }
        return view
    }

}