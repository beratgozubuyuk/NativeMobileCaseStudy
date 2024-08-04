package com.example.nativemobilecasestudy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nativemobilecasestudy.model.Product
import com.example.nativemobilecasestudy.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeListViewModel() : ViewModel() {

    private val repository = ProductRepository()

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getProducts()
                _products.postValue(productList)
                Log.d("HomeListViewModel", "Fetched products: $productList")
            } catch (e: Exception) {
                Log.e("HomeListViewModel", "Error fetching products", e)
            }
        }
    }

}