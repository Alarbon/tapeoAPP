package com.alarbon.tapeoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alarbon.tapeoapp.data.local.dao.BarDao
import com.alarbon.tapeoapp.data.local.dao.MenuItemDao
import com.alarbon.tapeoapp.data.local.dao.TownDao
import com.alarbon.tapeoapp.data.local.entity.BarEntity
import com.alarbon.tapeoapp.data.local.entity.MenuItemEntity
import com.alarbon.tapeoapp.data.local.entity.TownEntity

@Database(
    entities = [
        TownEntity::class,
        BarEntity::class,
        MenuItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class TapeoDatabase : RoomDatabase() {
    abstract fun townDao(): TownDao
    abstract fun barDao(): BarDao
    abstract fun menuItemDao(): MenuItemDao
}
