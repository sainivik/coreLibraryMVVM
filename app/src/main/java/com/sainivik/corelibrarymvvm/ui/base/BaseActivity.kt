package com.sainivik.corelibrarymvvm.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        attachViewModel()
    }

    protected abstract fun setBinding()
    protected abstract fun attachViewModel()
}