package com.sainivik.corelibrarymvvm.di.module


import com.sainivik.corelibrarymvvm.network.api.RetrofitApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://itunes.apple.com/"

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): RetrofitApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

            .client(okHttpClient)
            .build().create(RetrofitApi::class.java)

    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOKHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .readTimeout(1200, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val requestBuilder: Request.Builder = chain.request().newBuilder()
                requestBuilder.header("Content-Type", "application/json")
                // requestBuilder.header("x-hasura-admin-secret", "incredible-admin-secret")
                chain.proceed(requestBuilder.build())
            }
            .connectTimeout(1200, TimeUnit.SECONDS)
            .build()

    }

    private val authInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .build()

        return@Interceptor chain.proceed(request)
    }

}