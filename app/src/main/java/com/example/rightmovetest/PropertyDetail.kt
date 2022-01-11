package com.example.rightmovetest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PropertyDetail(
    @Expose
    @SerializedName("id")
    var id:Int,
    @Expose
    @SerializedName("price")
    var price:Int,
    @Expose
    @SerializedName("bedrooms")
    val bedrooms:Int,
    @Expose
    @SerializedName("bathrooms")
    val bathrooms:Int,
    @Expose
    @SerializedName("number")
    val number:String,
    @Expose
    @SerializedName("address")
    val address:String,
    @Expose
    @SerializedName("region")
    val region:String,
    @Expose
    @SerializedName("postcode")
    val postcode:String,
    @Expose
    @SerializedName("propertyType")
    val propertyType:String)
