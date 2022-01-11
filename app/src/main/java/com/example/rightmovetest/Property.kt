package com.example.rightmovetest
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class Property(
    @Expose
    @SerializedName("properties")
    val properties: List<PropertyDetail>)