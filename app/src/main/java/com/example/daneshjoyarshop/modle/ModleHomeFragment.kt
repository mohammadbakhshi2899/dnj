package com.example.daneshjoyarshop.modle

import android.util.Log
import com.example.daneshjoyarshop.net.ApiService
import com.example.daneshjoyarshop.net.CountryPresenterListner
import com.example.daneshjoyarshop.Test.TestHomeFragment
import com.example.daneshjoyarshop.dataClass.DataCategory
import com.example.daneshjoyarshop.dataClass.DataImageUrl
import com.example.daneshjoyarshop.dataClass.DataProduct
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ModleHomeFragment() :KoinComponent{

    private val api : ApiService by inject()
    fun sendDataProduct() = TestHomeFragment.productData()
    //fun sendDataCategory() = TestHomeFragment.sendCategory()

    fun sendImageForBanner(mListener: CountryPresenterListner<DataImageUrl>){

        api.getAPi()
            .getImageForBanner()
            .enqueue(object :Callback<DataImageUrl>{
                override fun onFailure(p0: Call<DataImageUrl>, p1: Throwable) {
                    Log.i("ERROR_GET_INFORMATION_FRO_SERVER" , p1.message.toString())
                    mListener.onFailure("خطا در گرفتن اطلاعات از سرور")
                }

                override fun onResponse(call: Call<DataImageUrl>, response: Response<DataImageUrl>) {
                    val data = response.body()
                    if (data != null)
                        mListener.onResponse(data)
                    else {
                        mListener.onFailure("notFoundData")
                    }
                }

            })

    }

    fun sendNewDataProducts(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getDataNewProducts()
            .enqueue(object : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()

                    if (data != null)
                    {
                        mListener.onResponse(data)
                    }else
                    {
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")

                    }
                }

            })
    }

    fun sendDiscountProducts(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getDataDiscountProducts()
            .enqueue(object  : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()
                    if (data != null)
                    {
                        mListener.onResponse(data)
                    }
                    else{
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                    }
                }

            })
    }

    fun sendTopSellingProducts(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getDataTopSellingProducts()
            .enqueue(object : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                   val data = response.body()
                    if (data != null)
                    {
                        mListener.onResponse(data)
                    }else{
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                    }
                }

            })
    }
    fun sendDataCategory(mListener: CountryPresenterListner<List<DataCategory>>){
        api.getAPi()
            .getDataCategory()
            .enqueue(object :Callback<List<DataCategory>>{
                override fun onFailure(call: Call<List<DataCategory>>, throwable: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

                override fun onResponse(
                    call: Call<List<DataCategory>>,
                    response: Response<List<DataCategory>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListener.onResponse(data)
                    else{
                        mListener.onFailure("مشکلی برای سرور پیش امده")
                    }
                }

            })

    }

}