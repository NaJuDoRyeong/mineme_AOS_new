package com.najudoryeong.mineme.core.network.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable


@Serializable
data class NetworkHomeMainResource internal constructor(
    val couple: Couple,
    val newStory: NewStory
)

@Serializable
data class Couple(
    val name: String,
    val startDate: String,
    val me: Person,
    val mine: Person
)

@Serializable
data class Person(
    val profileImage: String,
    val nickname: String,
    val description: String,
    val instaId: String,
    val birthday: String,
    val gender: String
)

@Serializable
data class NewStory(
    val postId: Int,
    val region: String,
    val date: String,
    val thumbnailImage: String
)

