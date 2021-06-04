package com.example.myselfapp.util

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import com.example.myselfapp.R
import com.example.myselfapp.data.DailyActivity
import com.example.myselfapp.data.Gallery
import com.example.myselfapp.data.Music
import com.example.myselfapp.data.Video

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

@BindingAdapter("video")
fun VideoView.setVideo(item: Video?) {
    val res = context.resources
    val videoId = res.getIdentifier(item?.path, "raw", context.packageName)
    val videoPath = "android.resource://" + context.packageName + "/" + videoId
    val mediaController = MediaController(context)

    item?.let {
        setVideoPath(videoPath)
        setMediaController(mediaController)
    }

    mediaController.setAnchorView(this)
}