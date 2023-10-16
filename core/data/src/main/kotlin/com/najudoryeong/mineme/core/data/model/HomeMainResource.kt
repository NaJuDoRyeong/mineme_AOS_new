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

import com.najudoryeong.mineme.core.model.data.Couple
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.NewStory
import com.najudoryeong.mineme.core.model.data.Person
import com.najudoryeong.mineme.core.network.model.NetworkCouple
import com.najudoryeong.mineme.core.network.model.NetworkHomeMainResource
import com.najudoryeong.mineme.core.network.model.NetworkNewStory
import com.najudoryeong.mineme.core.network.model.NetworkPerson

fun NetworkHomeMainResource.asDomainModel() = HomeMainResource(
    couple = couple.asDomainModel(),
    newStory = newStory.asDomainModel(),
)

fun NetworkCouple.asDomainModel() = Couple(
    name = name,
    startDate = startDate,
    me = me.asDomainModel(),
    mine = mine.asDomainModel(),
)

fun NetworkPerson.asDomainModel() = Person(
    profileImage = profileImage,
    nickname = nickname,
    description = description,
    instaId = instaId,
    birthday = birthday,
    gender = gender,
)

fun NetworkNewStory.asDomainModel() = NewStory(
    postId = postId,
    region = region,
    date = date,
    thumbnailImage = thumbnailImage,
)
