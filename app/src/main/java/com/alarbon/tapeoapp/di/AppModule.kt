package com.alarbon.tapeoapp.di

import android.content.Context
import androidx.room.Room
import com.alarbon.tapeoapp.data.local.TapeoDatabase
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
    fun provideDatabase(appContext: Context): TapeoDatabase {
        return Room.databaseBuilder(
            appContext,
            TapeoDatabase::class.java,
            "tapeo_database"
        ).build()
    }

    @Provides
    fun provideTownDao(database: TapeoDatabase) = database.townDao()

    @Provides
    fun provideBarDao(database: TapeoDatabase) = database.barDao()

    @Provides
    fun provideMenuItemDao(database: TapeoDatabase) = database.menuItemDao()
}
