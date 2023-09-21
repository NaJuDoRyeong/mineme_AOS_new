package com.najudoryeong.mineme.core.model.data

data class StoryCalendarResource constructor(
    val stories: List<Story>
)

data class Story(
    val region: String,
    val city: String,
    val posts: List<Post>
)

data class Post(
    val date: String,
    val thumbnail: String,
    val postId: Int
)