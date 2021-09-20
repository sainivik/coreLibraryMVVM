package com.technorapper.technoraploader.di.module

import com.sainivik.corelibrarymvvm.database.AppDatabase
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePicasso(): Picasso {
        return Picasso.get()
    }


}