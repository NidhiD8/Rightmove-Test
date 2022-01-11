package com.example.rightmovetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var propertyViewModel: PropertyViewModel
    var avgPrice:Double = 0.00
    var totalPrice:Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var propertyViewModelFactory = PropertyViewModelFactory()
        propertyViewModel = ViewModelProvider(this,propertyViewModelFactory).get(PropertyViewModel::class.java)

        propertyViewModel.getPropertyList()

        propertyViewModel.propertyList.observe(this, Observer { res->
            for (i in res.properties){
                totalPrice += i.price
            }
            avgPrice = (totalPrice / res.properties.size)
            updateUI(avgPrice)
        })
    }

    private fun updateUI(avgPrize:Double) {
        tvAvgPrice!!.text = String.format("%.2f",avgPrize)
    }
}