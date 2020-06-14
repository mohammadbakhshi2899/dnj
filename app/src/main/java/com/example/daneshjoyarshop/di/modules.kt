package com.example.daneshjoyarshop.di


import com.example.daneshjoyarshop.Fragment.AccountFragment
import com.example.daneshjoyarshop.Fragment.HomeFragment
import com.example.daneshjoyarshop.Fragment.ShopFragment
import com.example.daneshjoyarshop.Modle.ModleMainActivity
import com.example.daneshjoyarshop.View.ViewMainActivity
import org.koin.dsl.module.module


val Fragmentmodules = module {
    single { AccountFragment() }
    single { HomeFragment() }
    single { ShopFragment() }
}
val Modlemodules = module {
    single { ModleMainActivity() }
}
val apitmodules = module {  }
