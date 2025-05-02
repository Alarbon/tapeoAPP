package com.alarbon.tapeoapp.data.repository

import com.alarbon.tapeoapp.data.local.dao.TownDao
import com.alarbon.tapeoapp.domain.model.Town
import com.alarbon.tapeoapp.domain.repository.TownRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TownRepositoryImpl @Inject constructor(
    private val townDao: TownDao
) : TownRepository {

    override fun getTowns(): Flow<List<Town>> {
        return townDao.getAllTowns().map { entities ->
            entities.map { entity ->
                Town(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description,
                    imageUrl = entity.imageUrl
                )
            }
        }
    }
}
