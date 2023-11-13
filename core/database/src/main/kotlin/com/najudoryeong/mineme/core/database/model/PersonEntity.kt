package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val profileImage: String,
    val nickname: String,
    val description: String,
    val instaId: String,
    val birthday: String,
    val gender: String
)