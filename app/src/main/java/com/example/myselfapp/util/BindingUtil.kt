package com.example.myselfapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.myselfapp.data.DailyActivity
import com.example.myselfapp.data.Gallery
import com.example.myselfapp.data.Music

@BindingAdapter("image")
fun ImageView.setWalletImage(item: DailyActivity?) {
    val res = context.resources
    val imageId = res.getIdentifier(item?.image, "drawable", context.packageName)

    item?.let {
        setImageResource(imageId)
    }
}

@BindingAdapter("galleryImage")
fun ImageView.setGalleryImage(item: Gallery?) {
    val res = context.resources
    val imageId = res.getIdentifier(item?.image, "drawable", context.packageName)

    item?.let {
        setImageResource(imageId)
    }
}

@BindingAdapter("musicImage")
fun ImageView.setMusicImage(item: Music?) {
    val res = context.resources
    val imageId = res.getIdentifier(item?.image, "drawable", context.packageName)

    item?.let {
        setImageResource(imageId)
    }
}