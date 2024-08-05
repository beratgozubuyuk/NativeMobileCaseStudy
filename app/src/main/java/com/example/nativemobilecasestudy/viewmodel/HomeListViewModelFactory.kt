package com.example.nativemobilecasestudy.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeListViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}