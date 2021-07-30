package com.example.beautyproducts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.beautyproducts.R
import com.example.beautyproducts.databinding.FragmentHome1Binding
import com.example.beautyproducts.databinding.FragmentProductBinding

class ProductFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var mProductViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(layoutInflater)
        val view = binding.root

        mProductViewModel = ViewModelProvider(this ).get(ProductViewModel::class.java)

        binding.tvAddToBag.setOnClickListener{
            insertDataToDataBase()
        }
        return view
    }

    private fun insertDataToDataBase() {
        val name = binding.tvName.text.toString()
        val price = binding.tvPrice.text.toString()
        val size = binding.tvSize.text.toString()
        val description = binding.tvDescription.text.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}