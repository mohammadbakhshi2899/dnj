package com.example.daneshjoyarshop.utitlity

import android.widget.ImageView
import com.example.daneshjoyarshop.R
import com.squareup.picasso.Picasso
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PicassoUtitlity : KoinComponent {
    private val picasso : Picasso by inject()


    fun setImage(address : String , image : ImageView){
        picasso
            .load(address)
            .error(R.drawable.error)
            .placeholder(R.drawable.loading)
            .fit()
            .into(image)
    }
}