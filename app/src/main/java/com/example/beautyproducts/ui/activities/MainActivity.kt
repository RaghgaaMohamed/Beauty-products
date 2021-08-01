
package com.example.beautyproducts.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.beautyproducts.R
import com.example.beautyproducts.databinding.ActivityMainBinding
import com.example.beautyproducts.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

}




