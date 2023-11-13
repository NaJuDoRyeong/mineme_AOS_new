package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anniversary")
data class AnniversaryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: String,
    val day: Int
)
