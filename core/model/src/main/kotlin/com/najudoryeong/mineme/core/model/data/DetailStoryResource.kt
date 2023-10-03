package com.najudoryeong.mineme.core.model.data

data class DetailStoryResource constructor(
    val stories: List<DetailStory>
)

data class DetailStory(
    val region: String,
    val city: String,
    val isAnniversary: String,
    val anniversary: Anniversary?,
    val date: String,
    val images: List<String>,
    val postId: Int,
    val content: String,
    val author: String
)

data class Anniversary(
    val type: String,
    val day: Int
)