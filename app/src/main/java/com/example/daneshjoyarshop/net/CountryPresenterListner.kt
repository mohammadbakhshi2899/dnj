package com.example.daneshjoyarshop.net

interface CountryPresenterListner<M> {

    fun onResponse(data:M )
    fun onFailure(message:String)
}