package com.najudoryeong.mineme.core.model.data


data class StoryCalendarResource constructor(
    val stories: List<StoryWithYearMonth>
)

data class StoryRegionResource(
    val stories: List<StoryWithRegion>
)

data class StoryWithYearMonth(
    val year: String,
    val month: String,
    val posts: List<Post>
)

data class StoryWithRegion(
    val region: String,
    val city: String,
    val posts: List<Post>
)

data class Post(
    val date: String,
    val thumbnail: String,
    val postId: Int
)