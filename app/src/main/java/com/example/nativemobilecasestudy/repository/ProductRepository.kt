package com.example.nativemobilecasestudy.repository

import androidx.lifecycle.LiveData
import com.example.nativemobilecasestudy.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepository(private val productDao: ProductDao) {
    private val apiService = RetrofitClient.apiService

    suspend fun fetchProductsFromApi() {
        withContext(Dispatchers.IO) {
            try {
                val productList = apiService.getProducts()
                productDao.insertAll(productList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return productDao.getAllProducts()
    }

    fun getProductById(id: String): LiveData<Product> {
        return productDao.getProductById(id)
    }
}