package com.example.daneshjoyarshop.View

import android.annotation.SuppressLint
import android.content.Context
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daneshjoyarshop.Modle.ModleMainActivity
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.etc.Utitlity
import com.example.daneshjoyarshop.etc.setFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.view.*

@SuppressLint("ViewConstructor")
class ViewMainActivity(
    contextInstance: Context,
    private val fragmentManager: setFragment,
    private val manageMainMenu: Utitlity
) :
    FrameLayout(contextInstance) , PopupMenu.OnMenuItemClickListener{

    private val bottomNavigation: BottomNavigationView
    private val imgMainMenu: ImageView

    init {
        val mainView = inflate(context, R.layout.activity_main, this)
        bottomNavigation = mainView.bottomNavigationView
        imgMainMenu = mainView.img_menu
    }

    fun setupBottomNavigation(ItemChecked: Int, fragment: Fragment) {

        imgMainMenu.setOnClickListener {
            manageMainMenu.onCreatePopUpMenu(imgMainMenu)
        }
        bottomNavigation.menu.getItem(ItemChecked).isChecked = true

        fragmentManager.addFragment(fragment)
    }

    fun onBottomClick(fragments: Map<String, Fragment>) {
        bottomNavigation.setOnClickListener {
            when (it.id) {
                R.id.item_account -> {
                    replaceFragment(fragments[ModleMainActivity.KEY_ACCOUNT_FRAGMENT] ?: Fragment())
                }
                R.id.item_home -> {
                    replaceFragment(fragments[ModleMainActivity.KEY_HOME_FRAGMENT] ?: Fragment())
                }
                R.id.item_shop -> {
                    replaceFragment(fragments[ModleMainActivity.KEY_SHOP_FRAGMENT] ?: Fragment())
                }

            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager.replaceFragment(fragment)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.item_famous_question ->{Toast.makeText(context , "ItemQuestion" , Toast.LENGTH_SHORT).show()}
            R.id.item_call_me ->{Toast.makeText(context , "ItemCall" , Toast.LENGTH_SHORT).show()}
            R.id.item_report_problem ->{Toast.makeText(context , "ItemReport" , Toast.LENGTH_SHORT).show()}
            R.id.item_about_me ->{Toast.makeText(context , "ItemAbout" , Toast.LENGTH_SHORT).show()}
        }
        return true
    }
}