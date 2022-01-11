package com.example.rightmovetest.RetrofitImpl

import com.example.rightmovetest.Property
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class RetrofitRepository(private val retrofitService: RetrofitService) {
    suspend fun fetchPropertyDetails() : Flow<Response<Property>> {
        return  flow {
            val propertyInfo = retrofitService.getPropertyDetails()
            emit(propertyInfo)
        }
    }
}