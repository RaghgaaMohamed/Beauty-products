package com.example.beautyproducts.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyproducts.R
import com.example.beautyproducts.data.db.entities.Product

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

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView=itemView.findViewById(R.id.tv_name)
        val price:TextView=itemView.findViewById(R.id.tv_price)
        val size :TextView=itemView.findViewById(R.id.tv_size)
        val image:ImageView=itemView.findViewById(R.id.iv_product)


    }
}
