/*
 * Copyright 2023 KDW03
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    stories = stories.map { story -> story.asDomainModel() },
)

fun NetworkStoryRegionResource.asDomainModel() = StoryRegionResource(
    stories = stories.map { story -> story.asDomainModel() },
)

fun NetworkStoryWithRegion.asDomainModel() = StoryWithRegion(
    region = region,
    city = city,
    posts = posts.map { post -> post.asDomainModel() },
)

fun NetworkStoryWithYearMonth.asDomainModel() = StoryWithYearMonth(
    year = year,
    month = month,
    posts = posts.map { post -> post.asDomainModel() },
)

fun NetworkPost.asDomainModel() = Post(
    date = date,
    thumbnail = thumbnail,
    postId = postId,
)
