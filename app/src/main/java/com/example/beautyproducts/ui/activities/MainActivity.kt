package com.example.beautyproducts.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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


        binding.navigation.setOnNavigationItemReselectedListener { item->
            if (item.itemId== R.id.home_navigation){
                pushFragment(HomeFragment())}

        }
        binding.navigation.selectedItemId= R.id.home_navigation
    }


    fun pushFragment (fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_containar,fragment).commit()
    }
}
