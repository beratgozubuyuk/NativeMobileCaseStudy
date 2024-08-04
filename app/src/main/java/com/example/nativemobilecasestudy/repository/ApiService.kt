package com.example.nativemobilecasestudy.repository

import com.example.nativemobilecasestudy.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}