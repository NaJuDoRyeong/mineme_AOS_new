package com.najudoryeong.mineme.core.network.model

import kotlinx.serialization.Serializable;

@Serializable
data class NetworkHomeMainResource constructor(
    val couple: NetworkCouple,
    val newStory: NetworkNewStory
)

@Serializable
data class NetworkCouple(
    val name: String = "",
    val startDate: String = "",
    val me: NetworkPerson,
    val mine: NetworkPerson
)

@Serializable
data class NetworkPerson(
    val profileImage: String = "",
    val nickname: String = "",
    val description: String = "",
    val instaId: String = "",
    val birthday: String = "",
    val gender: String = ""
)

@Serializable
data class NetworkNewStory(
    val postId: Int,
    val region: String = "",
    val date: String = "",
    val thumbnailImage: String = ""
)

