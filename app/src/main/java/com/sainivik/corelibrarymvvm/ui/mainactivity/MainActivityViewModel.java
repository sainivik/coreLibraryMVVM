package com.sainivik.corelibrarymvvm.ui.mainactivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sainivik.corelibrarymvvm.helper.EventTask;
import com.sainivik.corelibrarymvvm.helper.Task;
import com.sainivik.corelibrarymvvm.network.model.BitmapModel;
import com.sainivik.corelibrarymvvm.network.model.SongsResponse;
import com.sainivik.corelibrarymvvm.network.repository.MainActivityRepository;

import java.net.MalformedURLException;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<EventTask> eventTaskMutableLiveData = new MutableLiveData<>();


    public void downloadImageThread(final String photoUrl, final int pos) {

        new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                eventTaskMutableLiveData.postValue(EventTask.loading(Task.DOWNLOADING));
            }

            @Override
            protected String doInBackground(String... params) {
                try {
                    Bitmap image = MainActivityRepository.downloadThisImage(photoUrl);
                    eventTaskMutableLiveData.postValue(EventTask.message(new BitmapModel(pos, image), Task.FIRSTIMAGE));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


                return "complete";
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                eventTaskMutableLiveData.postValue(EventTask.error(Task.DOWNLOADING));
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);

                eventTaskMutableLiveData.postValue(EventTask.success(data, Task.DOWNLOADING));

            }
        }.execute();
    }


    void getSongsList() {
        new AsyncTask<String, Void, SongsResponse>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                eventTaskMutableLiveData.postValue(EventTask.loading(Task.FLIKRURL));
            }

            @Override
            protected SongsResponse doInBackground(String... params) {
                SongsResponse data = new SongsResponse();
                data = MainActivityRepository.processImageListRequest();
                // Parse the JSON using the library of your choice
                return data;
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                eventTaskMutableLiveData.postValue(EventTask.error(Task.FLIKRURL));
            }

            @Override
            protected void onPostExecute(SongsResponse data) {
                super.onPostExecute(data);
                eventTaskMutableLiveData.postValue(EventTask.success(data, Task.FLIKRURL));
            }
        }.execute();
    }
}
