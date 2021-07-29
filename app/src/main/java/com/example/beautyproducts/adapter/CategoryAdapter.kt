package com.example.beautyproducts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyproducts.R

class CategoryAdapter(private var images : List<Int>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val itemPicture : ImageView = itemView.findViewById(R.id.iv_item)
        init {
            itemView.setOnClickListener { v : View ->

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_categories , parent , false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemPicture.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}