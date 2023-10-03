package com.najudoryeong.mineme.core.data.model

import com.najudoryeong.mineme.core.model.data.Anniversary
import com.najudoryeong.mineme.core.model.data.DetailStory
import com.najudoryeong.mineme.core.model.data.DetailStoryResource
import com.najudoryeong.mineme.core.network.model.NetworkAnniversary
import com.najudoryeong.mineme.core.network.model.NetworkDetailStory
import com.najudoryeong.mineme.core.network.model.NetworkDetailStoryResource

fun NetworkDetailStoryResource.asDomainModel() = DetailStoryResource(
    stories = stories.map { it.asDomainModel() }
)

fun NetworkDetailStory.asDomainModel() = DetailStory(
    region = region,
    city = city,
    isAnniversary = isAnniversary,
    anniversary = anniversary?.asDomainModel() ,
    date = date,
    images = images,
    postId = postId,
    content = content,
    author = author
)

fun NetworkAnniversary.asDomainModel() = Anniversary(
    type = type,
    day = day
)