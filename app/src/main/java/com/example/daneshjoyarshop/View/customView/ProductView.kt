package com.example.daneshjoyarshop.View.customView

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.Adapter.RecyclerProductAdapter
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.dataClass.DataProduct
import kotlinx.android.synthetic.main.product_view.view.*

class ProductView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val txtAll: AppCompatTextView
    private val txtTitle: AppCompatTextView
    private val listProduct: RecyclerView

    init {
        val mainView = inflate(context, R.layout.product_view, this)

        txtAll = mainView.txt_product_all
        txtTitle = mainView.txt_product_title
        listProduct = mainView.recycler_product

        val typeArray = context.obtainStyledAttributes(attrs , R.styleable.ProductView)
        val text = typeArray.getString(R.styleable.ProductView_textTitle)
        typeArray.recycle()

        listProduct.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        txtTitle.text = text
    }

    fun setAdapter(data : List<DataProduct>)
    {
        listProduct.adapter = RecyclerProductAdapter(data)
    }
}