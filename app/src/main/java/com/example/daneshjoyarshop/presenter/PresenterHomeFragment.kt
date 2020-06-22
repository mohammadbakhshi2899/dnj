package com.example.daneshjoyarshop.presenter

import android.util.Log
import android.widget.Toast
import com.example.daneshjoyarshop.fragment.HomeFragment
import com.example.daneshjoyarshop.modle.ModleHomeFragment
import com.example.daneshjoyarshop.net.CountryPresenterListner
import com.example.daneshjoyarshop.dataClass.DataCategory
import com.example.daneshjoyarshop.dataClass.DataImageUrl
import com.example.daneshjoyarshop.dataClass.DataProduct
import com.example.daneshjoyarshop.etc.BaseLifeCycle

class PresenterHomeFragment(val modle: ModleHomeFragment, val view: HomeFragment) :
    BaseLifeCycle {

    override fun OnCreate() {
        setUpCategoryRecycler()
        dataRecyclers()
        setUpBanners()
    }

    override fun onResume() {
        setUpCategoryRecycler()
        dataRecyclers()
        //setDataRecycler()
        setUpBanners()
    }

    private fun setDataRecycler() {
        view.setNewDataProductRecycler(modle.sendDataProduct())
        view.setDiscountProductRecycler(modle.sendDataProduct())
        view.setTopSellingProductRecycler(modle.sendDataProduct())

    }

    private fun setUpBanners() {
        modle.sendImageForBanner(object :CountryPresenterListner<DataImageUrl>{
            override fun onResponse(data: DataImageUrl) {
                view.setBannerImage(data)
            }

            override fun onFailure(message: String) {
                Toast.makeText(view.context , message , Toast.LENGTH_SHORT).show()
                Log.i("ERROR" , message)
            }

        })
    }

    private fun dataRecyclers() {
        setDataNewProducts()
        setDataDiscountProducts()
        setDataTopSellingProducts()
    }

    private fun setUpCategoryRecycler() {
        modle.sendDataCategory(object : CountryPresenterListner<List<DataCategory>>{
            override fun onResponse(data: List<DataCategory>) {
                view.setCategoryRecycler(data)
            }

            override fun onFailure(message: String) {
                Toast.makeText(view.context , message , Toast.LENGTH_SHORT).show()
                Log.i("ERROR" , message)
            }
        })
    }

    private fun setDataNewProducts() {
        modle.sendNewDataProducts(
            object : CountryPresenterListner<List<DataProduct>>{
                override fun onResponse(data: List<DataProduct>) {
                    view.setNewDataProductRecycler(data)
                }

                override fun onFailure(message: String) {
                    Toast.makeText(view.context , message , Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    private fun setDataDiscountProducts() {
        modle.sendDiscountProducts(
            object :CountryPresenterListner<List<DataProduct>>{
                override fun onResponse(data: List<DataProduct>) {
                    Toast.makeText(view.context ,"successfully" , Toast.LENGTH_SHORT).show()
                    view.setDiscountProductRecycler(data)
                }

                override fun onFailure(message: String) {
                    Toast.makeText(view.context , message , Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    private fun setDataTopSellingProducts() {
        modle.sendTopSellingProducts(
            object : CountryPresenterListner<List<DataProduct>>{
                override fun onResponse(data: List<DataProduct>) {
                    view.setTopSellingProductRecycler(data)
                }

                override fun onFailure(message: String) {
                    Toast.makeText(view.context , message , Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    override fun OnDestroyd() {
        TODO("Not yet implemented")
    }

}