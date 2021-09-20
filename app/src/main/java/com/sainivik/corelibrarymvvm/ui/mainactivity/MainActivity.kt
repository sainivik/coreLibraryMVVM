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
    var adapter: SongsAdapter? = null

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
        /* setAdapter()
         if (isNetworkConnected) {
             viewModel!!.songsList
         } else {
             Toast.makeText(this, "Please check your internet connection.", Toast.LENGTH_SHORT)
                 .show()
         }
         viewModel!!.eventTaskMutableLiveData.observe(this, { eventTask ->
             when (eventTask.status) {
                 Status.LOADING -> {
                     binding!!.progressCircular.show()
                     Log.d("Task", "Loading")
                 }
                 Status.SUCCESS -> {
                     binding!!.progressCircular.hide()
                     if (eventTask.data != null) {
                         if (eventTask.task === Task.FLIKRURL) {
                             val songsResponse = eventTask.data as SongsResponse?
                             songList.clear()
                             if (songsResponse != null && songsResponse.results != null) {
                                 // songList.addAll(songsResponse.results)
                                 adapter!!.notifyDataSetChanged()
                             }
                             //viewModel.downloadImageThread(flikrImageModel.getPhotos().getPhoto());
                         }
                         if (eventTask.task === Task.DOWNLOADING) {
                             Log.d("Downloading Complete", "########")
                         }
                         if (eventTask.task === Task.FIRSTIMAGE) {
                             val bitmapModel = eventTask.data as BitmapModel?
                             songList[bitmapModel!!.pos].bitmap = bitmapModel.bitmap
                             adapter!!.notifyItemChanged(bitmapModel.pos)
                             Log.d("pos", "" + bitmapModel.pos)
                         }
                     }
                 }
                 Status.ERROR -> {
                     binding!!.progressCircular.hide()
                     Log.d("Task", "error")
                 }
             }
         })*/
    }

    private val isNetworkConnected: Boolean
        private get() {
            val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
        }
}