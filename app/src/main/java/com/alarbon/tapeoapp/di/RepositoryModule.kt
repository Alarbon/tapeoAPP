package com.alarbon.tapeoapp.di

import com.alarbon.tapeoapp.data.local.dao.TownDao
import com.alarbon.tapeoapp.data.repository.TownRepositoryImpl
import com.alarbon.tapeoapp.domain.repository.TownRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideTownRepository(townDao: TownDao): TownRepository {
        return TownRepositoryImpl(townDao)
    }
}
