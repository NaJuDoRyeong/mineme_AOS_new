package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey val postId: Int,
    val date: String,
    val thumbnail: String,
    val calendarId: Int?, // 연결된 캘린더 ID
    val regionId: Int? // 연결된 지역 ID
)
