package com.example.nativemobilecasestudy.repository

import com.example.nativemobilecasestudy.model.Product

class ProductRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getProducts(): List<Product> {
        return apiService.getProducts()
    }
}