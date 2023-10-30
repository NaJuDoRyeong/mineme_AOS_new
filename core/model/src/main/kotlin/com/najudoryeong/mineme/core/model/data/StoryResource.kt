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

package com.najudoryeong.mineme.core.model.data

data class StoryCalendarResource constructor(
    val stories: List<StoryWithYearMonth>,
)

data class StoryRegionResource(
    val stories: List<StoryWithRegion>,
)

data class StoryWithYearMonth(
    val year: String,
    val month: String,
    val posts: List<Post>,
)

data class StoryWithRegion(
    val region: String,
    val city: String,
    val posts: List<Post>,
)

data class Post(
    val date: String,
    val thumbnail: String,
    val postId: Int,
)
