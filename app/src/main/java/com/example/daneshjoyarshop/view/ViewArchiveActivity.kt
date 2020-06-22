package com.example.daneshjoyarshop.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.adapter.ArchiveActivityRecyclerProductAdapter
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.dataClass.DataProduct
import com.example.daneshjoyarshop.etc.Utitlity
import kotlinx.android.synthetic.main.activity_archive.view.*
import kotlinx.android.synthetic.main.activity_main.view.*

@SuppressLint("ViewConstructor")
class ViewArchiveActivity(context: Context, private val utility: Utitlity) : FrameLayout(context) {


    private val txtTitle: AppCompatTextView
    private val imgBack: AppCompatImageView
    private val recyclerList: RecyclerView

    init {
        val mainView = View.inflate(context, R.layout.activity_archive, this)
        txtTitle = mainView.txt_title_archive_activity
        imgBack = mainView.img_back_archive_activity
        recyclerList = mainView.recycler_product_archive_activity

        recyclerList.layoutManager =
            GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)


    }


    fun onClickHandler() {
        imgBack.setOnClickListener { utility.onFinish() }
    }

    fun setAdapters(data : List<DataProduct>){
        recyclerList.adapter = ArchiveActivityRecyclerProductAdapter(data)
        recyclerList.visibility = View.VISIBLE
        progressBar_archive.visibility = View.INVISIBLE
    }

    fun setTitleText(title:String){
        txtTitle.text = title
    }
    fun showToast(message : String){
        Toast.makeText(context , message , Toast.LENGTH_SHORT).show()
    }


}