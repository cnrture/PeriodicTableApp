package com.canerture.periodictableapp

import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("setTextColumnNumber")
fun setTextColumnNumber(textView: TextView, columnNumber: Int?) {
    if (columnNumber == null) {
        textView.text = ""
    }   else {
        textView.text = columnNumber.toString()
    }
}

@BindingAdapter("setVisibleFrame")
fun setVisibleFrame(frameLayout: FrameLayout, columnNumber: Int?) {
    frameLayout.isVisible = columnNumber != null
}

@BindingAdapter("setVisible")
fun setVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("setBackgroundColor")
fun setBackgroundColor(cardView: CardView, color: Int?) {
    if (color != null) {
        cardView.setBackgroundResource(color)
    }
}