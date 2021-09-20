package com.sainivik.corelibrarymvvm.di.module

import androidx.room.Room
import com.sainivik.corelibrarymvvm.application.MyApp
import com.sainivik.corelibrarymvvm.database.AppDatabase
import com.sainivik.corelibrarymvvm.database.DatabaseConstants
import com.sainivik.corelibrarymvvm.database.dao.SongsMasterDao
import com.technorapper.technoraploader.di.scopes.ApplicationScoped

import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    @ApplicationScoped
    fun provideWDDatabase(context: MyApp): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, DatabaseConstants.DB_NAME
        )
            .fallbackToDestructiveMigration()
            // .addMigrations(WhideDatabase.MIGRATION_1_2) /*.allowMainThreadQueries()*/
            .build()
    }


    @ApplicationScoped
    @Provides
    fun provideSongsMasterDao(appDatabase: AppDatabase): SongsMasterDao {
        return appDatabase.getSongsMasterDao()
    }


}