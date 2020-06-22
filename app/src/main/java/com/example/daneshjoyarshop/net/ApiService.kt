package com.example.daneshjoyarshop.net

import com.example.daneshjoyarshop.dataClass.DataCategory
import com.example.daneshjoyarshop.dataClass.DataImageUrl
import com.example.daneshjoyarshop.dataClass.DataProduct
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiService {


    interface DataApi {
        @GET("image")
        fun getImageForBanner(): Call<DataImageUrl>

        @GET("json/categories.json")
        fun getDataCategory(): Call<List<DataCategory>>

        @GET("json/new_products.json")
        fun getDataNewProducts(): Call<List<DataProduct>>

        @GET("json/discount_products.json")
        fun getDataDiscountProducts(): Call<List<DataProduct>>

        @GET("json/top_selling_products.json")
        fun getDataTopSellingProducts(): Call<List<DataProduct>>

        @GET("json/new_products.json")
        fun getAllDataNewProducts(): Call<List<DataProduct>>

        @GET("json/discount_products.json")
        fun getAllDataDiscountProducts(): Call<List<DataProduct>>

        @GET("json/top_selling_products.json")
        fun getAllDataTopSellingProducts(): Call<List<DataProduct>>
    }

    fun getAPi(): DataApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://webroidlearning.ir/")
            .build()
            .create(DataApi::class.java)


}