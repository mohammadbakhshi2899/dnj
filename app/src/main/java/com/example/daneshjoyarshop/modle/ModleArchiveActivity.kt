package com.example.daneshjoyarshop.modle

import android.app.Activity
import com.example.daneshjoyarshop.enumeration.TypeGetProduct
import com.example.daneshjoyarshop.net.ApiService
import com.example.daneshjoyarshop.net.CountryPresenterListner
import com.example.daneshjoyarshop.view.customView.ProductView
import com.example.daneshjoyarshop.dataClass.DataProduct
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModleArchiveActivity(private val activity: Activity) :KoinComponent{

    private val api : ApiService by inject()

    fun getTitleAsActivity() = activity.intent.getStringExtra(ProductView.TITLE_KEY) ?: ""

    private fun getTypeProduct() =
        activity.intent.getSerializableExtra(ProductView.TYPE_KEY) as TypeGetProduct


    fun sendAllData(manyListenersException : CountryPresenterListner<List<DataProduct>>){

        when(getTypeProduct()){
            TypeGetProduct.TOP_SELLING_PRODUCT ->{ sendAllDataTopSellingProduct(manyListenersException)}
            TypeGetProduct.DISCOUNT_PRODUCT -> { sendAllDataDiscountProduct(manyListenersException)}
            TypeGetProduct.NEW_PRODUCT ->{ sendAllDataNewProduct(manyListenersException)}
        }

    }

    private fun sendAllDataNewProduct(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getAllDataNewProducts()
            .enqueue(object : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات ار سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListener.onResponse(data)
                    else
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

            })
    }
    private fun sendAllDataDiscountProduct(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getAllDataDiscountProducts()
            .enqueue(object : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات ار سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListener.onResponse(data)
                    else
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

            })
    }

    private fun sendAllDataTopSellingProduct(mListener: CountryPresenterListner<List<DataProduct>>){
        api.getAPi()
            .getAllDataTopSellingProducts()
            .enqueue(object : Callback<List<DataProduct>>{
                override fun onFailure(p0: Call<List<DataProduct>>, p1: Throwable) {
                    mListener.onFailure("خطا در دریافت اطلاعات ار سرور")
                }

                override fun onResponse(
                    p0: Call<List<DataProduct>>,
                    response: Response<List<DataProduct>>
                ) {
                    val data = response.body()
                    if (data != null)
                        mListener.onResponse(data)
                    else
                        mListener.onFailure("خطا در دریافت اطلاعات از سرور")
                }

            })
    }
}