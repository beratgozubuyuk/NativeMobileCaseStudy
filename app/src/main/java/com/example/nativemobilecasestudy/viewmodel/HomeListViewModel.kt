package com.example.nativemobilecasestudy.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativemobilecasestudy.model.Product
import com.example.nativemobilecasestudy.repository.ProductDatabase
import com.example.nativemobilecasestudy.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    val allProductsLiveData: LiveData<List<Product>>
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        allProductsLiveData = repository.getAllProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                repository.fetchProductsFromApi()
                allProductsLiveData.observeForever { productList ->
                    _products.postValue(productList)
                    Log.d("HomeListViewModel", "Fetched products: $productList")
                }
            } catch (e: Exception) {
                Log.e("HomeListViewModel", "Error fetching products", e)
            }
        }
    }
}