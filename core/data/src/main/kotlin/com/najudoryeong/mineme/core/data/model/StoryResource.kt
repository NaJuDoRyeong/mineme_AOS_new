package com.najudoryeong.mineme.core.data.model

import com.najudoryeong.mineme.core.model.data.Post
import com.najudoryeong.mineme.core.model.data.StoryCalendarResource
import com.najudoryeong.mineme.core.model.data.StoryRegionResource
import com.najudoryeong.mineme.core.model.data.StoryWithRegion
import com.najudoryeong.mineme.core.model.data.StoryWithYearMonth
import com.najudoryeong.mineme.core.network.model.NetworkPost
import com.najudoryeong.mineme.core.network.model.NetworkStoryCalendarResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryRegionResource
import com.najudoryeong.mineme.core.network.model.NetworkStoryWithRegion
import com.najudoryeong.mineme.core.network.model.NetworkStoryWithYearMonth

fun NetworkStoryCalendarResource.asDomainModel() = StoryCalendarResource(
    stories = stories.map { story -> story.asDomainModel() }
)

fun NetworkStoryRegionResource.asDomainModel() = StoryRegionResource(
    stories = stories.map { story -> story.asDomainModel() }
)




fun NetworkStoryWithRegion.asDomainModel() = StoryWithRegion(
    region = region,
    city = city,
    posts = posts.map { post -> post.asDomainModel() }
)

fun NetworkStoryWithYearMonth.asDomainModel() = StoryWithYearMonth(
    year = year,
    month = month,
    posts = posts.map { post -> post.asDomainModel() }
)



fun NetworkPost.asDomainModel() = Post(
    date = date,
    thumbnail = thumbnail,
    postId = postId
)

