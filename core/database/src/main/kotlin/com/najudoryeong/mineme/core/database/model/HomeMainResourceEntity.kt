package com.najudoryeong.mineme.core.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey



@Entity(
    tableName = "Couple",
    foreignKeys = [
        ForeignKey(
            entity = PersonEntity::class,
            parentColumns = ["personId"],
            childColumns = ["meId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PersonEntity::class,
            parentColumns = ["personId"],
            childColumns = ["partnerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],

    )
data class CoupleEntity(
    @PrimaryKey(autoGenerate = true) val coupleId: Long = 0L,
    val name: String,
    val startDate: String,
    val meId: Long,
    val partnerId: Long
)


@Entity(
    tableName = "Person",
)
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val personId: Long = 0L,
    val profileImage: String,
    val nickname: String,
    val description: String,
    val instaId: String,
    val birthday: String,
    val gender: String
)


@Entity(
    tableName = "Story"
)
data class NewStoryEntity(
    val postId: Long = 0L,
    val region: String,
    val date: String,
    val thumbnailImage: String
)

@Entity(
    tableName = "HomeMainResource",
    foreignKeys = [
        ForeignKey(
            entity = CoupleEntity::class,
            parentColumns = ["coupleId"],
            childColumns = ["coupleRefId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = NewStoryEntity::class,
            parentColumns = ["postId"],
            childColumns = ["newStoryRefId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class HomeMainResourceEntity(
    @PrimaryKey(autoGenerate = true) val resourceId: Long = 0L,
    val coupleRefId: Long,
    val newStoryRefId: Long
)


