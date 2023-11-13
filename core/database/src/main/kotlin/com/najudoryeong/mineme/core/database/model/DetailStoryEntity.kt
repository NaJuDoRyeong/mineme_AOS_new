package com.najudoryeong.mineme.core.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_story")
data class DetailStoryEntity(
    @PrimaryKey val postId: Int,
    val region: String,
    val city: String,
    val isAnniversary: String,
    @Embedded val anniversary: AnniversaryEntity,
    val date: String,
    val images: String, // JSON 형태로 저장할 수 있습니다.
    val content: String,
    val author: String
)