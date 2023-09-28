package com.najudoryeong.mineme.core.network.model

import kotlinx.serialization.Serializable


@Serializable
data class NetworkDetailStoryResource constructor(
    val stories: List<NetworkDetailStory>
)

@Serializable
data class NetworkDetailStory(
    val region: String,
    val city: String,
    val isAnniversary: String,
    val anniversary: NetworkAnniversary = NetworkAnniversary(),
    val date: String,
    val images: List<String>,
    val postId: Int,
    val content: String,
    val author: String
)

@Serializable
data class NetworkAnniversary(
    val type: String = "",
    val day: Int = 0
)