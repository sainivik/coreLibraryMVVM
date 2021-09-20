package com.sainivik.corelibrarymvvm.di.module

import android.content.Context
import androidx.room.Room
import com.sainivik.corelibrarymvvm.database.AppDatabase
import com.sainivik.corelibrarymvvm.database.DatabaseConstants
import com.sainivik.corelibrarymvvm.database.dao.SongsMasterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideWDDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, DatabaseConstants.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideSongsMasterDao(appDatabase: AppDatabase): SongsMasterDao {
        return appDatabase.getSongsMasterDao()
    }


}