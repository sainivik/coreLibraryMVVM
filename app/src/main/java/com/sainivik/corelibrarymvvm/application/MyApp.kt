package com.sainivik.corelibrarymvvm.application

import android.app.Application
import com.sainivik.corelibrarymvvm.utils.CustomBindingAdapter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        CustomBindingAdapter()
    }


}