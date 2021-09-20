package com.sainivik.corelibrarymvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


object CustomBindingAdapter {
    //lateinit var technoRapLoader: TechnoRapLoader

    @JvmStatic
    @BindingAdapter("android:loadFromUrl")
    fun loadFromUrl(view: ImageView, url: String) {
        /*if (url == null || url.equals("", ignoreCase = true)) {
            view.setImageResource(android.R.color.transparent);
            return
        }
        technoRapLoader.displayImage(url, view, R.drawable.loading)*/
    }

    operator fun invoke() {
       // this.technoRapLoader = technoRapLoader;

    }

}