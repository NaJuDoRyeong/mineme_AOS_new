package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "story_calendar")
data class StoryCalendarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val year: String,
    val month: String,
    @Relation(
        parentColumn = "id",
        entityColumn = "calendarId"
    )
    val posts: List<PostEntity>
)