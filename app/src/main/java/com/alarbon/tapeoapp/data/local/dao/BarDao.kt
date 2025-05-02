package com.alarbon.tapeoapp.data.local.dao;

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alarbon.tapeoapp.data.local.entity.BarEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BarDao {

    @Query("SELECT * FROM bars WHERE townId = :townId")
    fun getBarsByTown(townId: Int): Flow<List<BarEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBar(bar: BarEntity)

    @Query("DELETE FROM bars")
    suspend fun deleteAllBars()
}