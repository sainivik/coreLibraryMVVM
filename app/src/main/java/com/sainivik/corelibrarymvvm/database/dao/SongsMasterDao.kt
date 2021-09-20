package com.sainivik.corelibrarymvvm.database.dao

import androidx.room.*
import com.sainivik.corelibrarymvvm.model.SongsModel
import io.reactivex.Flowable
import java.util.*

@Dao
abstract class SongsMasterDao {

    @Query("SELECT * FROM songTable")
    abstract fun getAll(id: String): Flowable<SongsModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveSongData(data: SongsModel): Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveAllSongsData(data: ArrayList<SongsModel>): List<Long>


    @Transaction
    open fun insertWithTime(userInfoModel: SongsModel): Long? {
        userInfoModel.createdOn = Calendar.getInstance().time
        userInfoModel.updatedOn = Calendar.getInstance().time
        userInfoModel.updatedBy = "user"
        return saveSongData(userInfoModel)
    }

    @Transaction
    open fun insertAllWithTime(notificationList: ArrayList<SongsModel>): List<Long> {
        for (notificationModel in notificationList) {
            notificationModel.createdOn = Calendar.getInstance().time
            notificationModel.updatedOn = Calendar.getInstance().time
            notificationModel.updatedBy = "user"
        }
        return saveAllSongsData(notificationList)
    }

    @Transaction
    open fun upsert(userInfoModel: SongsModel?) {
        val id = insertWithTime(userInfoModel!!)
        if (id == -1L) {
            updateWithTime(userInfoModel)
        }
    }

    @Query("DELETE FROM songTable")
    abstract fun nukeTable()

    @Transaction
    open fun upsertAll(notificationList: ArrayList<SongsModel>) {
        val id = insertAllWithTime(notificationList)
        if (id[0] == -1L) {
            updateAllWithTime(notificationList)
        }
    }

    @Transaction
    open fun updateWithTime(userInfoModel: SongsModel) {
        userInfoModel.updatedOn = Calendar.getInstance().time
        userInfoModel.updatedBy = "user"
        update(userInfoModel)
    }

    @Transaction
    open fun updateAllWithTime(notificationList: ArrayList<SongsModel>) {
        for (notificationModel in notificationList) {
            notificationModel.updatedOn = Calendar.getInstance().time
            notificationModel.updatedBy = "user"
        }
        updateAll(notificationList)
    }

    @Update
    abstract fun update(userInfoModel: SongsModel?)

    @Update
    abstract fun updateAll(notificationList: ArrayList<SongsModel>)

}