package com.sainivik.corelibrarymvvm.ui.mainactivity

import PageAdapter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sainivik.corelibrarymvvm.R
import com.sainivik.corelibrarymvvm.adapters.SongsAdapter
import com.sainivik.corelibrarymvvm.databinding.ActivityMainBinding
import com.sainivik.corelibrarymvvm.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViewPager()
    }

    private fun setViewPager() {
        binding.viewPager.adapter = PageAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }



    override fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

    }


}