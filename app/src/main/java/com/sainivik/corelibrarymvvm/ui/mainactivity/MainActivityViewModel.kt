package com.sainivik.corelibrarymvvm.ui.mainactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sainivik.corelibrarymvvm.helper.EventTask

class MainActivityViewModel : ViewModel() {
    var eventTaskMutableLiveData = MutableLiveData<EventTask<*>>()

    // var reposetory : MainActivityRepository()

}