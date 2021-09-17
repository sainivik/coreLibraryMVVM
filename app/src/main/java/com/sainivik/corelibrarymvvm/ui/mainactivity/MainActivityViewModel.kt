package com.sainivik.corelibrarymvvm.ui.mainactivity

import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sainivik.corelibrarymvvm.helper.EventTask
import com.sainivik.corelibrarymvvm.helper.EventTask.Companion.error
import com.sainivik.corelibrarymvvm.helper.EventTask.Companion.loading
import com.sainivik.corelibrarymvvm.helper.EventTask.Companion.message
import com.sainivik.corelibrarymvvm.helper.EventTask.Companion.success
import com.sainivik.corelibrarymvvm.helper.Task
import com.sainivik.corelibrarymvvm.network.model.BitmapModel
import com.sainivik.corelibrarymvvm.network.model.SongsResponse
import com.sainivik.corelibrarymvvm.network.repository.MainActivityRepository.downloadThisImage
import com.sainivik.corelibrarymvvm.network.repository.MainActivityRepository.processImageListRequest
import java.net.MalformedURLException

class MainActivityViewModel : ViewModel() {
    var eventTaskMutableLiveData = MutableLiveData<EventTask<*>>()
    fun downloadImageThread(photoUrl: String?, pos: Int) {/*
        object : AsyncTask<String?, String?, String>() {
            override fun onPreExecute() {
                super.onPreExecute()
                eventTaskMutableLiveData.postValue(loading<Any>(Task.DOWNLOADING))
            }

            protected override fun doInBackground(vararg params: String): String {
                try {
                    val image = downloadThisImage(photoUrl)
                    eventTaskMutableLiveData.postValue(
                        message(
                            BitmapModel(pos, image),
                            Task.FIRSTIMAGE
                        )
                    )
                } catch (e: MalformedURLException) {
                    e.printStackTrace()
                }
                return "complete"
            }

            override fun onCancelled() {
                super.onCancelled()
                eventTaskMutableLiveData.postValue(error<Any>(Task.DOWNLOADING))
            }

            override fun onPostExecute(data: String) {
                super.onPostExecute(data)
                eventTaskMutableLiveData.postValue(success(data, Task.DOWNLOADING))
            }
        }.execute()*/
    }

    // Parse the JSON using the library of your choice
    val songsList: Unit
        get() {
            /*object : AsyncTask<String?, Void?, SongsResponse?>() {
                override fun onPreExecute() {
                    super.onPreExecute()
                    eventTaskMutableLiveData.postValue(loading<Any>(Task.FLIKRURL))
                }

                protected override fun doInBackground(vararg params: String): SongsResponse? {
                    var data: SongsResponse? = SongsResponse()
                    data = processImageListRequest()
                    // Parse the JSON using the library of your choice
                    return data
                }

                override fun onCancelled() {
                    super.onCancelled()
                    eventTaskMutableLiveData.postValue(error<Any>(Task.FLIKRURL))
                }

                override fun onPostExecute(data: SongsResponse?) {
                    super.onPostExecute(data)
                    eventTaskMutableLiveData.postValue(success(data, Task.FLIKRURL))
                }
            }.execute()*/
        }
}