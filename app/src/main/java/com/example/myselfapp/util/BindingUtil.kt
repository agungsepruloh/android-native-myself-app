package com.example.myselfapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.myselfapp.data.DailyActivity

@BindingAdapter("image")
fun ImageView.setWalletImage(item: DailyActivity?) {
    val res = context.resources
    val imageId = res.getIdentifier(item?.image, "drawable", context.packageName)

    item?.let {
        setImageResource(imageId)
    }
}