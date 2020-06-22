package com.example.daneshjoyarshop.modle

import com.example.daneshjoyarshop.fragment.AccountFragment
import com.example.daneshjoyarshop.fragment.HomeFragment
import com.example.daneshjoyarshop.fragment.ShopFragment
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ModleMainActivity : KoinComponent {

    private val homeFragment : HomeFragment by inject()
    private val accountFragment : AccountFragment by inject()
    private val shopFragment : ShopFragment by inject()

    companion object{
        const val KEY_ACCOUNT_FRAGMENT = "accountFragment"
        const val KEY_HOME_FRAGMENT = "homeFragment"
        const val KEY_SHOP_FRAGMENT = "shopFragment"

        private const val INDEX_ACCOUNT_FRAGMENT = 0
        private const val INDEX_HOME_FRAGMENT = 1
        private const val INDEX_SHOP_FRAGMENT = 2
    }

    fun getMainActivity() = homeFragment
    fun getMainItemChecked() = INDEX_HOME_FRAGMENT

    fun getAllFragments() = mapOf(
        KEY_ACCOUNT_FRAGMENT to accountFragment ,
        KEY_HOME_FRAGMENT to homeFragment ,
        KEY_SHOP_FRAGMENT to shopFragment
    )
}