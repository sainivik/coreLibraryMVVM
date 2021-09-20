package com.sainivik.corelibrarymvvm.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachViewModel()
    }

    protected abstract fun attachViewModel()
}