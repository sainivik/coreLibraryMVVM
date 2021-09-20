package com.sainivik.corelibrarymvvm.application

import android.app.Application
import com.sainivik.corelibrarymvvm.utils.CustomBindingAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : Application() {
    @Inject
    lateinit var picasso: Picasso
    override fun onCreate() {
        super.onCreate()

        CustomBindingAdapter(picasso)
    }


}