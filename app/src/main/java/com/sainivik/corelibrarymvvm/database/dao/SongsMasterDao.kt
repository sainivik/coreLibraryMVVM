package com.sainivik.corelibrarymvvm.database.dao

import androidx.room.*
import com.sainivik.corelibrarymvvm.model.SongsModel
import io.reactivex.Flowable
import java.util.*
import kotlin.collections.ArrayList

@Dao
abstract class SongsMasterDao {

    @Query("SELECT * FROM songTable")
    abstract fun getAll(): Flowable<List<SongsModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveSongData(data: SongsModel): Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveAllSongsData(data: ArrayList<SongsModel>): List<Long>


    @Transaction
    open fun insertWithTime(model: SongsModel): Long? {
        model.createdOn = Calendar.getInstance().time
        model.updatedOn = Calendar.getInstance().time
        model.updatedBy = "user"
        return saveSongData(model)
    }

    @Transaction
    open fun insertAllWithTime(songList: ArrayList<SongsModel>): List<Long> {
        for (model in songList) {
            model.createdOn = Calendar.getInstance().time
            model.updatedOn = Calendar.getInstance().time
            model.updatedBy = "user"
        }
        return saveAllSongsData(songList)
    }

    @Transaction
    open fun upsert(model: SongsModel?) {
        val id = insertWithTime(model!!)
        if (id == -1L) {
            updateWithTime(model)
        }
    }

    @Query("DELETE FROM songTable")
    abstract fun nukeTable()

    @Transaction
    open fun upsertAll(songsList: ArrayList<SongsModel>) {
        val id = insertAllWithTime(songsList)
        if (id[0] == -1L) {
            updateAllWithTime(songsList)
        }
    }

    @Transaction
    open fun updateWithTime(model: SongsModel) {
        model.updatedOn = Calendar.getInstance().time
        model.updatedBy = "user"
        update(model)
    }

    @Transaction
    open fun updateAllWithTime(songList: ArrayList<SongsModel>) {
        for (model in songList) {
            model.updatedOn = Calendar.getInstance().time
            model.updatedBy = "user"
        }
        updateAll(songList)
    }

    @Update
    abstract fun update(model: SongsModel?)

    @Update
    abstract fun updateAll(songLIst: ArrayList<SongsModel>)

}