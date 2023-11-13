package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "story_region")
data class StoryRegionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val region: String,
    val city: String,
    @Relation(
        parentColumn = "id",
        entityColumn = "regionId"
    )
    val posts: List<PostEntity>
)