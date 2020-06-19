package com.example.daneshjoyarshop.View.customView

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView(context: Context , attr : AttributeSet) : AppCompatTextView(context , attr) {

    init {
        drawLine()
        textSize = 12f
    }

    fun setCustomView(value : String){
        text = value
        drawLine()
    }

    private fun drawLine() {
        val span = SpannableString(text)
        span.setSpan(StrikethroughSpan(), 0, text.length, Spanned.SPAN_MARK_MARK)
        text = span

    }
}