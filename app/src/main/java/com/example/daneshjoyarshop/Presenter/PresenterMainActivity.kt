package com.example.daneshjoyarshop.Presenter

import com.example.daneshjoyarshop.Modle.ModleMainActivity
import com.example.daneshjoyarshop.View.ViewMainActivity
import com.example.daneshjoyarshop.etc.BaseLifeCycle

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val modle: ModleMainActivity
) : BaseLifeCycle {
    override fun OnCreate() {
        setUpBottomNavigation()
        onBottomClick()
    }

    private fun setUpBottomNavigation(){
        view.setupBottomNavigation(modle.getMainItemChecked() , modle.getMainActivity())
    }

    private fun onBottomClick(){
        view.onBottomClick(modle.getAllFragments())
    }

    override fun OnDestroyd() {
        TODO("Not yet implemented")
    }
}