package com.example.daneshjoyarshop.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.R
import kotlinx.android.synthetic.main.category_recycler_item_home_fragment.view.*

class RecyclerCategoryAdapter( val data: List<String>) :
    RecyclerView.Adapter<RecyclerCategoryAdapter.RecyclerCategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        RecyclerCategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.category_recycler_item_home_fragment,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerCategoryViewHolder, position: Int) {
        holder.setCategoryName(data[position])
    }

    inner class RecyclerCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textTitle : AppCompatTextView = itemView.title_category_name

        fun setCategoryName(name:String){
            textTitle.text = name
        }
    }

    override fun getItemCount()=data.size
}