package com.alarbon.tapeoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alarbon.tapeoapp.data.local.entity.TownEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TownDao {

    @Query("SELECT * FROM towns")
    fun getAllTowns(): Flow<List<TownEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTown(town: TownEntity)

    @Query("DELETE FROM towns")
    suspend fun deleteAllTowns()
}