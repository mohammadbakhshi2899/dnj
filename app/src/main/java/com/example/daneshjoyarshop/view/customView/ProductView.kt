package com.example.daneshjoyarshop.view.customView

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.activity.ArchiveActivity
import com.example.daneshjoyarshop.adapter.RecyclerProductAdapter
import com.example.daneshjoyarshop.enumeration.TypeGetProduct
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.dataClass.DataProduct
import kotlinx.android.synthetic.main.product_view.view.*

class ProductView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    companion object {
        const val TITLE_KEY = "title"
        const val TYPE_KEY = "type"
    }

    private val txtAll: AppCompatTextView
    private val txtTitle: AppCompatTextView
    private val listProduct: RecyclerView

    init {
        val mainView = inflate(context, R.layout.product_view, this)

        txtAll = mainView.txt_product_all
        txtTitle = mainView.txt_product_title
        listProduct = mainView.recycler_product

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.ProductView)
        val text = typeArray.getString(R.styleable.ProductView_textTitle)
        typeArray.recycle()

        listProduct.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)

        txtTitle.text = text
    }

    fun setAdapter(data: List<DataProduct>, type: TypeGetProduct) {
        if (data.size >= 9) {
            val intent = Intent(
                Intent(
                    context,
                    ArchiveActivity::class.java
                )
            )
            intent.putExtra(TITLE_KEY, txtTitle.text.toString())
            intent.putExtra(TYPE_KEY, type)
            txtAll.visibility = View.VISIBLE
            txtAll.setOnClickListener {
                context.startActivity(
                    intent
                )
            }
        }

        listProduct.adapter = RecyclerProductAdapter(data)
    }
}