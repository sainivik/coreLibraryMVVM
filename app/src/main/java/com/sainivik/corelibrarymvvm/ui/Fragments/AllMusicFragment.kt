package com.sainivik.corelibrarymvvm.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sainivik.corelibrarymvvm.R
import com.sainivik.corelibrarymvvm.adapters.RecyclerViewClickListener
import com.sainivik.corelibrarymvvm.adapters.SongsAdapter
import com.sainivik.corelibrarymvvm.databinding.FragmentAllMusicBinding
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.helper.Status
import com.sainivik.corelibrarymvvm.helper.Task
import com.sainivik.corelibrarymvvm.model.SongsModel
import com.sainivik.corelibrarymvvm.model.SongsResponse
import com.sainivik.corelibrarymvvm.ui.base.BaseFragment
import com.sainivik.corelibrarymvvm.ui.mainactivity.MainActivityViewModel
import com.sainivik.corelibrarymvvm.utils.CheckInternetConnection
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AllMusicFragment : BaseFragment() {
    lateinit var binding: FragmentAllMusicBinding
    lateinit var viewModel: MainActivityViewModel
    private val songList = ArrayList<SongsModel>()
    var adapter: SongsAdapter? = null


    override fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        if (CheckInternetConnection.isInternetConnected(requireContext())) {
            viewModel.getSongList()
        } else {

            Toast.makeText(activity, "Please check your internet connection", Toast.LENGTH_SHORT)
                .show()

        }
        viewModel.response.observe(this, androidx.lifecycle.Observer { parseSongList(it) })

    }

    private fun setAdapter() {
        adapter = SongsAdapter(songList, object : RecyclerViewClickListener {
            override fun onClick(view: View?, pos: Int) {
                viewModel.saveSong(songList[pos])
                Toast.makeText(
                    activity,
                    "TITLE is now saved in database",
                    Toast.LENGTH_SHORT
                ).show()

            }
        })
        binding.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_all_music,
            container,
            false
        )
        setAdapter()
        return binding.root
    }

    private fun parseSongList(eventTask: EventTask<Any>) {

        when (eventTask.status) {
            Status.LOADING -> {
                binding.showProgress = true
            }
            Status.SUCCESS -> {
                binding.showProgress = false

                if (eventTask.task == Task.GET_SONGS) {
                    var response: SongsResponse? = eventTask.data as SongsResponse

                    if (response?.result != null) {
                        songList.clear()
                        songList.addAll(response.result)
                        adapter!!.notifyDataSetChanged()


                    }


                }


            }
            Status.ERROR -> {
                binding.showProgress = false

                Toast.makeText(activity, eventTask.msg, Toast.LENGTH_SHORT).show()

            }
        }


    }


}