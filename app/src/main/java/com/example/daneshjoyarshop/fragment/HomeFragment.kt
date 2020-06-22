package com.example.daneshjoyarshop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daneshjoyarshop.adapter.RecyclerCategoryAdapter
import com.example.daneshjoyarshop.enumeration.TypeGetProduct
import com.example.daneshjoyarshop.presenter.PresenterHomeFragment
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.utitlity.PicassoUtitlity
import com.example.daneshjoyarshop.dataClass.DataCategory
import com.example.daneshjoyarshop.dataClass.DataImageUrl
import com.example.daneshjoyarshop.dataClass.DataProduct
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {
    private val presenter: PresenterHomeFragment by inject()
    private val picasso : PicassoUtitlity by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.home_fragment, container, false)


    fun setCategoryRecycler(data : List<DataCategory>){
        category_recycler_home_fragment.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        category_recycler_home_fragment.adapter = RecyclerCategoryAdapter(data , context!!)
    }

    fun setNewDataProductRecycler(data : List<DataProduct>){
        new_product_recycler.setAdapter(data , TypeGetProduct.NEW_PRODUCT)
    }

    fun setDiscountProductRecycler(data : List<DataProduct>){
        discount_recycler.setAdapter(data, TypeGetProduct.DISCOUNT_PRODUCT)
    }

    fun setTopSellingProductRecycler(data : List<DataProduct>){
        top_selling_recycler.setAdapter(data , TypeGetProduct.TOP_SELLING_PRODUCT)
    }

    fun setBannerImage(data:DataImageUrl){
        picasso.setImage(data.image1 , img_banner1_home_fragment)
        picasso.setImage(data.image2 , img_banner2_home_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //presenter.OnCreate()

    }

    fun showToast(message :String)
    {
        Toast.makeText(context , message , Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

}