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

package com.najudoryeong.mineme.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkHomeMainResource constructor(
    val couple: NetworkCouple,
    val newStory: NetworkNewStory,
)

@Serializable
data class NetworkCouple(
    val name: String = "",
    val startDate: String = "",
    val me: NetworkPerson,
    val mine: NetworkPerson,
)

@Serializable
data class NetworkPerson(
    val profileImage: String = "",
    val nickname: String = "",
    val description: String = "",
    val instaId: String = "",
    val birthday: String = "",
    val gender: String = "",
)

@Serializable
data class NetworkNewStory(
    val postId: Int = -1,
    val region: String = "",
    val date: String = "",
    val thumbnailImage: String = "",
)
