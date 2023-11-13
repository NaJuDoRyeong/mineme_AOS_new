package com.najudoryeong.mineme.core.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "couple")
data class CoupleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val startDate: String,
    @Embedded(prefix = "me_") val me: PersonEntity,
    @Embedded(prefix = "mine_") val mine: PersonEntity
)
