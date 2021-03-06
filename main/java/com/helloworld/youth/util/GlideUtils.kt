package com.helloworld.util

import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.CropTransformation

fun ImageView.loadImage(uri: String?) {
    Glide.with(this).load(uri).into(this)
}

fun ImageView.loadImage(uri: Uri?) {
    Glide.with(this).load(uri).into(this)
}

fun ImageView.loadImage(@DrawableRes uri: Int) {
    Glide.with(this).load(uri).into(this)
}

fun ImageView.loadImage(uri: String?, @DrawableRes holder: Int) {
    Glide.with(this).load(uri).apply(RequestOptions.placeholderOf(holder)).into(this)
}

fun ImageView.loadImage(uri: String?, requestListener: RequestListener<Drawable?>) {
    Glide.with(this).load(uri).listener(requestListener).into(this)
}

fun ImageView.loadImage(uri: String?, width: Int, height: Int) {
    val multi = MultiTransformation(CropTransformation(width, height))
    Glide.with(this).load(uri).apply(RequestOptions.bitmapTransform(multi).dontAnimate())
        .into(this)
}

fun ImageView.loadImageCenterCrop(uri: String?, @DrawableRes holder: Int? = null) {
    Glide.with(this).load(uri)
        .apply(RequestOptions().dontAnimate().dontTransform().centerCrop().apply {
            if (holder != null) {
                this.placeholder(holder)
            }
        }).into(this)
}

fun ImageView.loadGif(
    uri: String?,
    requestListener: RequestListener<GifDrawable?>? = null,
    centerCrop: Boolean? = null, @DrawableRes holder: Int? = null
) {
    var requestOptions = RequestOptions().dontTransform()
    if (centerCrop != null) {
        requestOptions = requestOptions.centerCrop()
    }
    if (holder != null) {
        requestOptions = requestOptions.placeholder(holder)
    }
    if (requestListener != null) {
        Glide.with(this).asGif().load(uri).apply(requestOptions).listener(requestListener)
            .into(this)
    } else {
        Glide.with(this).asGif().load(uri).apply(requestOptions).into(this)
    }
}
