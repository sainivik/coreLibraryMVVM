package com.sainivik.corelibrarymvvm.ui.mainactivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sainivik.corelibrarymvvm.R;
import com.sainivik.corelibrarymvvm.adapters.RecyclerViewClickListener;
import com.sainivik.corelibrarymvvm.adapters.SongsAdapter;
import com.sainivik.corelibrarymvvm.databinding.ActivityMainBinding;
import com.sainivik.corelibrarymvvm.helper.EventTask;
import com.sainivik.corelibrarymvvm.helper.Task;
import com.sainivik.corelibrarymvvm.network.model.BitmapModel;
import com.sainivik.corelibrarymvvm.network.model.ResultsItem;
import com.sainivik.corelibrarymvvm.network.model.SongsResponse;
import com.sainivik.corelibrarymvvm.ui.base.BaseActivity;
import com.sainivik.corelibrarymvvm.utils.Alerts;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private ArrayList<ResultsItem> songList = new ArrayList<>();
    SongsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

    private void setAdapter() {
        adapter = new SongsAdapter(songList, viewModel, this, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int pos) {
                Alerts.rideHistoryDialog(songList.get(pos), MainActivity.this);

            }
        });
        binding.setAdapter(adapter);
    }

    @Override
    protected void attachViewModel() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        setAdapter();
        if (isNetworkConnected()) {
            viewModel.getSongsList();
        } else {
            Toast.makeText(this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
        }
        viewModel.eventTaskMutableLiveData.observe(this, new Observer<EventTask>() {
            @Override
            public void onChanged(EventTask eventTask) {
                switch (eventTask.status) {
                    case LOADING:
                        binding.progressCircular.show();
                        Log.d("Task", "Loading");
                        break;
                    case SUCCESS:
                        binding.progressCircular.hide();
                        if (eventTask.data != null) {
                            if (eventTask.task == Task.FLIKRURL) {
                                SongsResponse songsResponse = (SongsResponse) eventTask.data;
                                songList.clear();

                                if (songsResponse != null && songsResponse.getResults() != null) {
                                    songList.addAll(songsResponse.getResults());
                                    adapter.notifyDataSetChanged();
                                }
                                //viewModel.downloadImageThread(flikrImageModel.getPhotos().getPhoto());
                            }
                            if (eventTask.task == Task.DOWNLOADING) {
                                Log.d("Downloading Complete", "########");
                            }
                            if (eventTask.task == Task.FIRSTIMAGE) {
                                BitmapModel bitmapModel = (BitmapModel) eventTask.data;
                                songList.get(bitmapModel.getPos()).setBitmap(bitmapModel.getBitmap());
                                adapter.notifyItemChanged(bitmapModel.getPos());
                                Log.d("pos", "" + bitmapModel.getPos());
                            }

                        }
                        break;
                    case ERROR:
                        binding.progressCircular.hide();
                        Log.d("Task", "error");
                        break;
                }


            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
