package com.example.nativemobilecasestudy.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val id: String,
    val name: String,
    val price: String,
    val description: String,
    val imageUrl: String
)