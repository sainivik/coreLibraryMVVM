package com.sainivik.corelibrarymvvm.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

class CheckInternetConnection() {


    companion object {
        fun isInternetConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }


}
