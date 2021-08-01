package com.example.beautyproducts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.beautyproducts.R
import com.example.beautyproducts.adapters.ModelProduct
import com.example.beautyproducts.data.db.entities.Product
import com.example.beautyproducts.data.repositories.ProductRepository
import com.example.beautyproducts.databinding.FragmentProductBinding
import com.example.beautyproducts.data.db.ProductDatabase as ProductDatabase


class ProductFragment : Fragment() {

    private val args: ProductFragmentArgs by navArgs()
    lateinit var binding: FragmentProductBinding
    var modelProduct: ModelProduct? = null
    private lateinit var mProductViewModel: ProductViewModel


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {


        binding = FragmentProductBinding.inflate(layoutInflater)
        val view = binding.root

        //db
        val mDb = ProductDatabase(requireContext())

        //repository
        val mRepository = ProductRepository(mDb)

        //factory
        val factory = ProductViewModelFactory(mRepository)

        //view model object
        mProductViewModel = ViewModelProviders.of(this, factory).get(ProductViewModel::class.java)

        //init product
        modelProduct = args.model
        binding.tvName.text = modelProduct?.name
        binding.tvSize.text = modelProduct?.size
        binding.tvPrice.text = modelProduct?.price
//        binding.ivProduct.setImageResource(modelProduct?.images ?: 0)


        // set items on clickListener
        binding.tvPlus.setOnClickListener {
            var number = binding.tvNumber.text.toString().toInt()
            number++
            binding.tvNumber.text = number.toString()
        }

        binding.tvMinus.setOnClickListener {
            var number = binding.tvNumber.text.toString().toInt()
            number--
            if (number > 0) {
                binding.tvNumber.text = number.toString()
            }
        }

        binding.tvAddToBag.setOnClickListener {
             insertDataToDatabase()
            val action = ProductFragmentDirections.actionProductFragmentToCartFragment()
            findNavController().navigate(action)
        }

        return view
    }


    // insert to database from product fragment
    private fun insertDataToDatabase() {
        //get data
        val name = binding.tvName.text.toString()
        val price = binding.tvPrice.text.toString().toDouble()
        val size = binding.tvSize.text.toString().toInt()
        val number = binding.tvNumber.text.toString().toInt()

        //insert data
        val product = Product(name, price, size, number)

        //access to fun add product from viewModel
        mProductViewModel.addProduct(product)
    }





}
