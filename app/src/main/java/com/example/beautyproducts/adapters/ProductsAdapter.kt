package com.example.beautyproducts.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.beautyproducts.R
import com.example.beautyproducts.data.db.entities.Product
import com.example.beautyproducts.ui.fragments.HomeFragment

class ProductsAdapter(var modelList:List<ModelProduct> , private val listener: OnItemClickListener):RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val productItem =LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ViewHolder(productItem )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.initialize(modelList.get(position) , listener)

    }

    override fun getItemCount(): Int {
        return modelList.size
    }




    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val name: TextView=itemView.findViewById(R.id.tv_name)
        val price:TextView=itemView.findViewById(R.id.tv_price)
        val size :TextView=itemView.findViewById(R.id.tv_size)
        val image:ImageView=itemView.findViewById(R.id.iv_product)

        fun initialize(model : ModelProduct , listener: OnItemClickListener){
            name.text = model.name
            size.text = model.size
            price.text = model.price
            image.setImageResource(model.images)

            itemView.setOnClickListener{
                listener.onItemClick(bindingAdapterPosition ,model )

            }

        }

    }
}
interface OnItemClickListener{
    fun onItemClick(position: Int , modelProduct: ModelProduct)
}