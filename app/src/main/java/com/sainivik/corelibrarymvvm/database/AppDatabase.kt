package com.sainivik.corelibrarymvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sainivik.corelibrarymvvm.database.dao.SongsMasterDao
import com.sainivik.corelibrarymvvm.model.SongsModel
import com.whide.partner.data.repository.utils.RoomConverters

@Database(
    entities = [SongsModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    RoomConverters::class
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getSongsMasterDao(): SongsMasterDao


}


