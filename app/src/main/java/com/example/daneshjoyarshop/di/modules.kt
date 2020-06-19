package com.example.daneshjoyarshop.di


import com.example.daneshjoyarshop.Fragment.AccountFragment
import com.example.daneshjoyarshop.Fragment.HomeFragment
import com.example.daneshjoyarshop.Fragment.ShopFragment
import com.example.daneshjoyarshop.Modle.ModleHomeFragment
import com.example.daneshjoyarshop.Modle.ModleMainActivity
import com.example.daneshjoyarshop.Presenter.PresenterHomeFragment
import com.example.daneshjoyarshop.Utitlity.PicassoUtitlity
import com.example.daneshjoyarshop.View.ViewMainActivity
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
}
