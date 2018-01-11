package com.iortynskyi.hmsd.extensions

import android.graphics.PorterDuff
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import android.widget.TextView
import com.iortynskyi.hmsd.R
import com.squareup.picasso.Picasso

fun ImageView.changeColor(@ColorRes color: Int) = this.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_ATOP)

fun TextView.setTextColorRes(@ColorRes colorRes: Int) {
    this.setTextColor(ContextCompat.getColor(context, colorRes))
}

fun ImageView.loadUrl(url: String, @DrawableRes placeholder: Int = R.drawable.ic_launcher_background) {
    Picasso.with(context).load(url).placeholder(placeholder).error(placeholder).into(this)
}