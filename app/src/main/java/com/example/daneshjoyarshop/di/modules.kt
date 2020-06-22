package com.example.daneshjoyarshop.di


import com.example.daneshjoyarshop.fragment.AccountFragment
import com.example.daneshjoyarshop.fragment.HomeFragment
import com.example.daneshjoyarshop.fragment.ShopFragment
import com.example.daneshjoyarshop.modle.ModleHomeFragment
import com.example.daneshjoyarshop.modle.ModleMainActivity
import com.example.daneshjoyarshop.net.ApiService
import com.example.daneshjoyarshop.presenter.PresenterHomeFragment
import com.example.daneshjoyarshop.utitlity.PicassoUtitlity
import com.squareup.picasso.Picasso
import org.koin.dsl.module.module


val Fragmentmodules = module {
    single { AccountFragment() }
    single { HomeFragment() }
    single { ShopFragment() }
}
val Modlemodules = module {
    single { ModleHomeFragment() }
    single {  PresenterHomeFragment(get() , get()) }
    single { ModleMainActivity() }

}
val apitmodules = module {
    single { PicassoUtitlity() }
    single { Picasso.with(get()) }
    single { ApiService() }
}
