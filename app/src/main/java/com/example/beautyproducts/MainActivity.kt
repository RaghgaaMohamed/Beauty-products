package com.example.beautyproducts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beautyproducts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var imagesList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        postToList()

        binding.rvCategories.layoutManager = LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        binding.rvCategories.adapter = CategoryAdapter(imagesList)
    }

    private fun postToList() {
        imagesList.add(R.drawable.flat1)
        imagesList.add(R.drawable.flat2)
        imagesList.add(R.drawable.flat3)
        imagesList.add(R.drawable.flat4)
        imagesList.add(R.drawable.flat5)
        imagesList.add(R.drawable.flat6)


    }
}
