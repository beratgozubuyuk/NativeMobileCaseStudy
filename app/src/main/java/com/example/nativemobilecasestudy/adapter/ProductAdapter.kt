package com.example.nativemobilecasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nativemobilecasestudy.R
import com.example.nativemobilecasestudy.databinding.HomeItemBinding
import com.example.nativemobilecasestudy.model.Product

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        with(holder.binding) {
            nameTextView.text = product.name
            priceTextView.text = product.price+" TL"
            if (product.imageUrl != null) {
                Glide.with(imageView.context)
                    .load(product.imageUrl)
                    .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.people) // Placeholder resim
            }
        }
    }

    override fun getItemCount(): Int = products.size
}