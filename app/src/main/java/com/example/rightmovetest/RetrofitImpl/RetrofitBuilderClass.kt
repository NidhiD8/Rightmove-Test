package com.example.rightmovetest.RetrofitImpl

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderClass {

   // var retrofitService: RetrofitService? = null
    val BASE_URL = "https://raw.githubusercontent.com/rightmove/Code-Challenge-Android/master/"

    fun getInstance() : Retrofit {
           /* if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }*/
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        }

    fun apiService() : RetrofitService{
        return getInstance().create(RetrofitService::class.java)
    }
    fun providePropertyRepository() = RetrofitRepository(apiService())

}