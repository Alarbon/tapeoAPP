package com.alarbon.tapeoapp.domain.repository

import com.alarbon.tapeoapp.domain.model.Town
import kotlinx.coroutines.flow.Flow

interface TownRepository {
    fun getTowns(): Flow<List<Town>>
}

