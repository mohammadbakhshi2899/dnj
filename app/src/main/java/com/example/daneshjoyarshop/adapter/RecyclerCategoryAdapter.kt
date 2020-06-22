package com.example.daneshjoyarshop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.activity.ArchiveActivity
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.dataClass.DataCategory
import kotlinx.android.synthetic.main.category_recycler_item_home_fragment.view.*

class RecyclerCategoryAdapter( val data: List<DataCategory> , val context:Context) :
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


        fun setCategoryName(data : DataCategory){
            textTitle.text = data.title
            textTitle.setOnClickListener {
                val intent = Intent(context , ArchiveActivity::class.java)
                Toast.makeText(context , data.title , Toast.LENGTH_SHORT).show()
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount()=data.size
}