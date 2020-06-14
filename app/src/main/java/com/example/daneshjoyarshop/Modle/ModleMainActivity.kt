package com.example.daneshjoyarshop.Modle

import androidx.fragment.app.Fragment
import com.example.daneshjoyarshop.Fragment.AccountFragment
import com.example.daneshjoyarshop.Fragment.HomeFragment
import com.example.daneshjoyarshop.Fragment.ShopFragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModleMainActivity : KoinComponent {

    private val homeFragment : HomeFragment by inject()
    private val accountFragment : AccountFragment by inject()
    private val shopFragment : ShopFragment by inject()

    companion object{
        val KEY_ACCOUNT_FRAGMENT = "accountFragment"
        val KEY_HOME_FRAGMENT = "homeFragment"
        val KEY_SHOP_FRAGMENT = "shopFragment"

        private val INDEX_ACCOUNT_FRAGMENT = 0
        private val INDEX_HOME_FRAGMENT = 1
        private val INDEX_SHOP_FRAGMENT = 2
    }

    fun getMainActivity() = homeFragment
    fun getMainItemChecked() = INDEX_HOME_FRAGMENT

    fun getAllFragments() = mapOf<String , Fragment>(
        KEY_ACCOUNT_FRAGMENT to accountFragment ,
        KEY_HOME_FRAGMENT to homeFragment ,
        KEY_SHOP_FRAGMENT to shopFragment
    )
}