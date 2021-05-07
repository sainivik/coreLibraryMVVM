package com.sainivik.corelibrarymvvm.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.sainivik.corelibrarymvvm.R;
import com.sainivik.corelibrarymvvm.databinding.DetailsDialogBinding;
import com.sainivik.corelibrarymvvm.network.model.ResultsItem;

public class Alerts {
    public static void rideHistoryDialog(ResultsItem resultsItem, Context context) {

        Dialog dialog = new Dialog(context);
        DetailsDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.details_dialog, null, false);
        dialog.setContentView(binding.getRoot());
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        //  dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationBottom;
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.setModel(resultsItem);
        dialog.show();

    }


}
