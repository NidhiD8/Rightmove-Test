package com.example.rightmovetest

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rightmovetest.RetrofitImpl.RetrofitRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class PropertyViewModel (private val dispatcher: CoroutineDispatcher, private val retrofitRepository: RetrofitRepository): ViewModel(), LifecycleObserver{

    val propertyList = MutableLiveData<Property>()

    fun getPropertyList(){
      viewModelScope.launch(dispatcher) {
          try {
              retrofitRepository.fetchPropertyDetails().collect { response ->
                  if(response.isSuccessful){
                      propertyList.postValue(response.body())
                  }
              }
          } catch (e:Exception){
              e.printStackTrace()
          }
      }
    }
}