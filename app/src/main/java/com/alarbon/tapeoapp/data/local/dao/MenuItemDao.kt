package com.alarbon.tapeoapp.data.local.dao;

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alarbon.tapeoapp.data.local.entity.MenuItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuItemDao {

    @Query("SELECT * FROM menu_items WHERE barId = :barId")
    fun getMenuItemsByBar(barId: Int): Flow<List<MenuItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMenuItem(menuItem: MenuItemEntity)

    @Query("DELETE FROM menu_items")
    suspend fun deleteAllMenuItems()
}