package com.najudoryeong.mineme.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkStoryCalendarResource constructor(
    val stories: List<NetworkStoryWithYearMonth>
)
@Serializable
data class NetworkStoryRegionResource constructor(
    val stories: List<NetworkStoryWithRegion>
)

@Serializable
data class NetworkStoryWithYearMonth(
    val year: String,
    val month: String,
    val posts: List<NetworkPost>
)

@Serializable
data class NetworkStoryWithRegion(
    val region: String,
    val city: String,
    val posts: List<NetworkPost>
)


@Serializable
data class NetworkPost(
    val date: String,
    val thumbnail: String,
    val postId: Int
)