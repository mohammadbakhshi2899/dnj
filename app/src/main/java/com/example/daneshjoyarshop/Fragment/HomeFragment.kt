package com.example.daneshjoyarshop.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daneshjoyarshop.Adapter.RecyclerCategoryAdapter
import com.example.daneshjoyarshop.Presenter.PresenterHomeFragment
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.dataClass.DataProduct
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {
    private val presenter: PresenterHomeFragment by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.home_fragment, container, false)


    fun setUpRecyclers(data: List<DataProduct> , datas :List<String>) {
        customViewProduct.setAdapter(data)
        discount_recycler.setAdapter(data)
        offer_recycler.setAdapter(data)
        category_recycler_home_fragment.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        category_recycler_home_fragment.adapter = RecyclerCategoryAdapter(datas)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.OnCreate()

    }

}