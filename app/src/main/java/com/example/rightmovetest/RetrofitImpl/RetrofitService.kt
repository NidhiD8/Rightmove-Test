package com.example.rightmovetest.RetrofitImpl

import com.example.rightmovetest.Property
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface RetrofitService {
    @GET("properties.json")
    suspend fun getPropertyDetails(): Response<Property>


}