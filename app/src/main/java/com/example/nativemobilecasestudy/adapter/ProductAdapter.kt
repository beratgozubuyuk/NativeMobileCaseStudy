package com.example.nativemobilecasestudy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nativemobilecasestudy.R
import com.example.nativemobilecasestudy.databinding.HomeItemBinding
import com.example.nativemobilecasestudy.model.Product

class ProductAdapter(private val onItemClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList: List<Product> = listOf()

    inner class ProductViewHolder(val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.cardView.setOnClickListener {
                val product = productList[adapterPosition]
                onItemClick(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        with(holder.binding) {
            nameTextView.text = product.name
            priceTextView.text = product.price + " TL"

            if (product.imageUrl.isNotEmpty()) {
                Glide.with(imageView.context)
                    .load(product.imageUrl)
                    .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.people)
            }
        }
    }

    override fun getItemCount() = productList.size

    fun setProducts(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }
}