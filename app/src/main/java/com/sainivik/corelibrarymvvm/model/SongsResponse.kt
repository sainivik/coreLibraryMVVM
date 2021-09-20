package com.sainivik.corelibrarymvvm.model

import com.google.gson.annotations.SerializedName

data class SongsResponse(
    @SerializedName("results")
    var result: ArrayList<SongsModel> = ArrayList<SongsModel>()
)


