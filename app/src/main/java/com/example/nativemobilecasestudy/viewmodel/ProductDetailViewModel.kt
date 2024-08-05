package com.example.nativemobilecasestudy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nativemobilecasestudy.model.Product
import com.example.nativemobilecasestudy.repository.ProductDatabase
import com.example.nativemobilecasestudy.repository.ProductRepository

class ProductDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository = ProductRepository(ProductDatabase.getDatabase(application).productDao())
    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    fun getProduct(id: String) {
        repository.getProductById(id).observeForever { product ->
            _product.postValue(product)
        }
    }
}