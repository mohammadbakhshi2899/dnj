package com.example.daneshjoyarshop.presenter

import com.example.daneshjoyarshop.modle.ModleArchiveActivity
import com.example.daneshjoyarshop.net.CountryPresenterListner
import com.example.daneshjoyarshop.view.ViewArchiveActivity
import com.example.daneshjoyarshop.dataClass.DataProduct
import com.example.daneshjoyarshop.etc.BaseLifeCycle

class PresenterArchiveActivity(val view: ViewArchiveActivity, val modle: ModleArchiveActivity) : BaseLifeCycle {
    override fun OnCreate() {
        view.onClickHandler()
        //view.setAdapters(TestHomeFragment.productData())
        view.setTitleText(modle.getTitleAsActivity())
        setRecyclerData()
    }

    private fun setRecyclerData(){
        modle.sendAllData( object  : CountryPresenterListner<List<DataProduct>>{
            override fun onResponse(data: List<DataProduct>) {
                view.setAdapters(data)
            }

            override fun onFailure(message: String) {
                view.showToast(message)
            }

        })
    }

    override fun OnDestroyd() {
        TODO("Not yet implemented")
    }
}