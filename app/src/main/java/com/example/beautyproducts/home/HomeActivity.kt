package com.example.beautyproducts.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.beautyproducts.R
import com.example.beautyproducts.modelproduct
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        navigation.setOnNavigationItemReselectedListener { item->
            if (item.itemId==R.id.home_navigation){
                pushFragment(HomeFragment())}

            }
        navigation.selectedItemId=R.id.home_navigation
    }


        fun pushFragment (fragment : Fragment){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_containar,fragment).commit()
        }
}