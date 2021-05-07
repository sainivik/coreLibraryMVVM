package com.sainivik.corelibrarymvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sainivik.corelibrarymvvm.R;
import com.sainivik.corelibrarymvvm.databinding.ItemRecyclerviewBinding;
import com.sainivik.corelibrarymvvm.network.model.ResultsItem;
import com.sainivik.corelibrarymvvm.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ResultsItem> list;
    private RecyclerViewClickListener listener;
    private MainActivityViewModel viewModel;

    public SongsAdapter(ArrayList<ResultsItem> list, MainActivityViewModel viewModel, Context context, RecyclerViewClickListener listener) {
        this.list = list;
        this.viewModel = viewModel;
        this.listener = listener;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecyclerviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_recyclerview, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setModel(list.get(position));

        if (list.get(position).getBitmap() != null) {
            holder.binding.ivImage.setImageBitmap(list.get(position).getBitmap());
        } else {
            viewModel.downloadImageThread(list.get(position).getArtworkUrl100(), position);
        }
        holder.binding.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewBinding binding;

        public MyViewHolder(@NonNull ItemRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }


}
