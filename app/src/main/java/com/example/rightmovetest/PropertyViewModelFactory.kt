package com.example.rightmovetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rightmovetest.RetrofitImpl.RetrofitBuilderClass
import com.example.rightmovetest.RetrofitImpl.RetrofitRepository
import kotlinx.coroutines.Dispatchers

class PropertyViewModelFactory : ViewModelProvider.Factory{
    lateinit var retrofitRepository: RetrofitRepository
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        retrofitRepository = RetrofitBuilderClass.providePropertyRepository()
        if (modelClass.isAssignableFrom(PropertyViewModel::class.java)) {
            return PropertyViewModel(Dispatchers.Main,retrofitRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
