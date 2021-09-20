package com.sainivik.corelibrarymvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sainivik.corelibrarymvvm.R
import com.squareup.picasso.Picasso


object CustomBindingAdapter {
    lateinit var picasso: Picasso

    @JvmStatic
    @BindingAdapter("android:loadFromUrl")
    fun loadFromUrl(view: ImageView, url: String) {
        if (url == null || url.equals("", ignoreCase = true)) {

            return
        }
        picasso.load(url).error(R.drawable.loader).into(view)
    }

    operator fun invoke(picasso: Picasso) {
        this.picasso = picasso;

    }

}