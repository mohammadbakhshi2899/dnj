package com.example.daneshjoyarshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.utitlity.PicassoUtitlity
import com.example.daneshjoyarshop.view.customView.CustomTextView
import com.example.daneshjoyarshop.dataClass.DataProduct
import kotlinx.android.synthetic.main.item_archive_activity_product_recycler.view.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class ArchiveActivityRecyclerProductAdapter(private val data: List<DataProduct>) :
    RecyclerView.Adapter<ArchiveActivityRecyclerProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_archive_activity_product_recycler, parent, false)
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setView(data[position])
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , KoinComponent {

        private val setter : PicassoUtitlity by inject()
        private val rootLayout : ConstraintLayout = itemView.constraint_recycler_product_item
        private val discountPrice : CustomTextView = itemView.customTextView_discount
        private val realPrice : AppCompatTextView = itemView.textView_cost
        private val image :AppCompatImageView = itemView.img_recycler_item
        private val title : AppCompatTextView = itemView.txt_title

        fun setView(item : DataProduct){

            setter.setImage(item.imgAddress , image)
            title.text = item.title
            realPrice.text = item.price
            if(item.discount)
            {
                discountPrice.visibility = View.VISIBLE
                realPrice.text = item.priceDiscount
                discountPrice.setCustomView(item.price)
            }else{
                discountPrice.visibility = View.INVISIBLE
                realPrice.text = item.price
            }


        }
    }

    override fun getItemCount() = data.size
}