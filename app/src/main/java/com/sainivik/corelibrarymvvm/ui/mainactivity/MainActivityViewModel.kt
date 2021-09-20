package com.sainivik.corelibrarymvvm.ui.mainactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.model.SongsModel
import com.sainivik.corelibrarymvvm.network.repository.MainActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: MainActivityRepository
) : ViewModel() {
    var response = MutableLiveData<EventTask<Any>>()
    var dbResponse = MutableLiveData<EventTask<Any>>()


    fun getSongList() {
        repository.getSongs(response)
    }

    fun getSongsFromDB() {
        repository.getSongsFromDB(dbResponse)
    }

    fun saveSong(songsModel: SongsModel) {
        repository.saveSong(songsModel)
    }


}