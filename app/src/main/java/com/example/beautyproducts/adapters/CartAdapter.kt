package com.example.beautyproducts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyproducts.R
import com.example.beautyproducts.data.db.entities.Product

class CartAdapter :RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private var productList = emptyList<Product>()

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView =itemView.findViewById(R.id.tv_name)
        val price: TextView =itemView.findViewById(R.id.tv_price)
        val size : TextView =itemView.findViewById(R.id.tv_size)
        val image: ImageView =itemView.findViewById(R.id.iv_product)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cart_item , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price.toString()
        holder.size.text = currentItem.size.toString()
//        holder.image.setImageResource(currentItem.picture)

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setData(product: List<Product>){
        this.productList = product
        notifyDataSetChanged()
    }
}