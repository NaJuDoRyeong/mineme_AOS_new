package com.najudoryeong.mineme.core.model.data

data class HomeMainResource constructor(
    val couple: Couple,
    val newStory: NewStory
)

data class Couple(
    val name: String,
    val startDate: String,
    val me: Person,
    val mine: Person
)


data class Person(
    val profileImage: String,
    val nickname: String,
    val description: String,
    val instaId: String,
    val birthday: String,
    val gender: String
)

data class NewStory(
    val postId: Int,
    val region: String,
    val date: String,
    val thumbnailImage: String
)

