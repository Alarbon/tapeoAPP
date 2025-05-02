package com.alarbon.tapeoapp.data.local.entity;

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_items")
data class MenuItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val barId: Int,
    val name: String,
    val description: String? = null,
    val price: Double? = null,
    val imageUrl: String? = null
)