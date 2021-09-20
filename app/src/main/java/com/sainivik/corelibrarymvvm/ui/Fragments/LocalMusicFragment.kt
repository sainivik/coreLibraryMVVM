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
import com.sainivik.corelibrarymvvm.databinding.FragmentLocalMusicBinding
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.helper.Status
import com.sainivik.corelibrarymvvm.helper.Task
import com.sainivik.corelibrarymvvm.model.SongsModel
import com.sainivik.corelibrarymvvm.ui.base.BaseFragment
import com.sainivik.corelibrarymvvm.ui.mainactivity.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocalMusicFragment : BaseFragment() {
    lateinit var binding: FragmentLocalMusicBinding
    lateinit var viewModel: MainActivityViewModel
    private val songList = ArrayList<SongsModel>()
    var adapter: SongsAdapter? = null


    override fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getSongsFromDB()
        viewModel.dbResponse.observe(this, androidx.lifecycle.Observer { parseSongList(it) })

    }

    private fun setAdapter() {
        adapter = SongsAdapter(songList, object : RecyclerViewClickListener {
            override fun onClick(view: View?, pos: Int) {
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
            R.layout.fragment_local_music,
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

                if (eventTask.task == Task.GET_SONGS_FROM_DB) {
                    var list: ArrayList<SongsModel>? = eventTask.data as ArrayList<SongsModel>

                    if (list != null) {
                        songList.clear()
                        songList.addAll(list)
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