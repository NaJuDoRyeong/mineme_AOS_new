package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_story")
data class NewStoryEntity(
    @PrimaryKey val postId: Int,
    val region: String,
    val date: String,
    val thumbnailImage: String
)