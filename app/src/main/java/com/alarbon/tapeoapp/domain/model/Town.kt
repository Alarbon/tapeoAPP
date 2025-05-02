package com.alarbon.tapeoapp.domain.model

data class Town(
    val id: Int,
    val name: String,
    val description: String? = null,
    val imageUrl: String? = null
)
