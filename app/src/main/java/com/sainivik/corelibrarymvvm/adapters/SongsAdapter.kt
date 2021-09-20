package com.sainivik.corelibrarymvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sainivik.corelibrarymvvm.R
import com.sainivik.corelibrarymvvm.adapters.SongsAdapter.MyViewHolder
import com.sainivik.corelibrarymvvm.databinding.ItemRecyclerviewBinding
import com.sainivik.corelibrarymvvm.model.SongsModel
import java.util.*

class SongsAdapter(
    private val list: ArrayList<SongsModel>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemRecyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recyclerview,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.model = list[position]
        holder.binding.llMain.setOnClickListener { v -> listener.onClick(v, position) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(var binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(
            binding.root
        )
}