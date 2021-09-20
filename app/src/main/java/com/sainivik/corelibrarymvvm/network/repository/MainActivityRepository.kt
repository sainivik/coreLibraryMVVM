package com.sainivik.corelibrarymvvm.network.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sainivik.corelibrarymvvm.database.dao.SongsMasterDao
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.helper.Task
import com.sainivik.corelibrarymvvm.model.SongsModel
import com.sainivik.corelibrarymvvm.network.api.RetrofitApi
import io.reactivex.functions.Consumer
import kotlinx.coroutines.*
import javax.inject.Inject


class MainActivityRepository @Inject constructor(
    private val myApi: RetrofitApi, private val songsMasterDao: SongsMasterDao
) {

    fun getSongs(
        response: MutableLiveData<EventTask<Any>>
    ) {
        val handler = exceptionHandler(response, Task.GET_SONGS)
        response.postValue(EventTask.loading(Task.GET_SONGS))
        CoroutineScope(Dispatchers.IO).launch(handler) {
            val responseData = myApi.getSongs()
            withContext(Dispatchers.Main) {
                response.postValue(EventTask.success(responseData, Task.GET_SONGS))

            }
        }

    }


    private fun exceptionHandler(
        response: MutableLiveData<EventTask<Any>>,
        task: Task
    ): CoroutineExceptionHandler {

        return CoroutineExceptionHandler { _, exception ->
            Log.e("error", exception.message)
            response.postValue(
                EventTask.error(
                    task,

                    "Server Error",

                    )
            )
            println("Caught $exception with suppressed ${exception.suppressed.contentToString()}")
        }
    }

    fun saveSong(songsModel: SongsModel) {

        CoroutineScope(Dispatchers.IO).launch() {
            songsMasterDao.upsert(songsModel)
            withContext(Dispatchers.Main) {
                Log.d("db", "save to db")
                //  response.postValue(EventTask.success(responseData, Task.GET_SONGS))

            }
        }

    }

    fun getSongsFromDB(response: MutableLiveData<EventTask<Any>>) {

        val handler = exceptionHandler(response, Task.GET_SONGS_FROM_DB)
        response.postValue(EventTask.loading(Task.GET_SONGS_FROM_DB))
        CoroutineScope(Dispatchers.IO).launch(handler) {
            var responseData: List<SongsModel>? = null
            songsMasterDao.getAll().subscribe(Consumer {
                responseData = it
                response.postValue(EventTask.success(responseData!!, Task.GET_SONGS_FROM_DB))

            })

        }

    }
}