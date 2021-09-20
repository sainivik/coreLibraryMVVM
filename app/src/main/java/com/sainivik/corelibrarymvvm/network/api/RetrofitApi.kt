package com.sainivik.corelibrarymvvm.network.api

import com.sainivik.corelibrarymvvm.model.SongsResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitApi {

    @Headers("Accept: application/json")
    @GET("search?term=Michael+jackson&media=musicVideo")
    suspend fun getSongs(): SongsResponse
}
