package com.sainivik.corelibrarymvvm.network.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.helper.Task
import com.sainivik.corelibrarymvvm.network.api.RetrofitApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.*
import javax.inject.Inject

class MainActivityRepository @Inject constructor(
   private val myApi: RetrofitApi
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
}