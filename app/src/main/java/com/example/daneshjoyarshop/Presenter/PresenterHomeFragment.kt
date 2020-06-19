package com.example.daneshjoyarshop.Presenter

import com.example.daneshjoyarshop.Fragment.HomeFragment
import com.example.daneshjoyarshop.Modle.ModleHomeFragment
import com.example.daneshjoyarshop.etc.BaseLifeCycle

class PresenterHomeFragment(val modle : ModleHomeFragment  , val view : HomeFragment)  : BaseLifeCycle{
    override fun OnCreate() {
        set()
    }

    fun set(){
        view.setUpRecyclers(modle.sendDataProduct() , modle.sendDataCategory())
    }
    override fun OnDestroyd() {
        TODO("Not yet implemented")
    }
}