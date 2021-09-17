package com.sainivik.corelibrarymvvm.network.api
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApi
{
    @GET("")
    fun getMovies(): Call<JsonElement>
}