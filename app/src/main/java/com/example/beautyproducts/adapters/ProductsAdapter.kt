package com.example.beautyproducts.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyproducts.R

class ProductsAdapter(var modelList:List<ModelProduct>):RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val productItem =LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ViewHolder(productItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= modelList.get(position)
        holder.name.setText(model.name)
        holder.price.setText(model.price)
        holder.size.setText(model.size)
        holder.image.setImageResource(model.images)

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView=itemView.findViewById(R.id.name_product)
        val price:TextView=itemView.findViewById(R.id.price_product)
        val size :TextView=itemView.findViewById(R.id.size_product)
        val image:ImageView=itemView.findViewById(R.id.image_product)

    }
}