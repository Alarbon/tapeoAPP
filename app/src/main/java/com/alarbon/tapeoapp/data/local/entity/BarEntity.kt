package com.alarbon.tapeoapp.data.local.entity;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bars")
data class BarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val townId: Int,
    val name: String,
    val description: String? = null,
    val imageUrl: String? = null
)