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
    newStory = newStory.asDomainModel()
)

fun NetworkCouple.asDomainModel() = Couple(
    name = name,
    startDate = startDate,
    me = me.asDomainModel(),
    mine = mine.asDomainModel()
)

fun NetworkPerson.asDomainModel() = Person(
    profileImage = profileImage,
    nickname = nickname,
    description = description,
    instaId = instaId,
    birthday = birthday,
    gender = gender
)

fun NetworkNewStory.asDomainModel() = NewStory(
    postId = postId,
    region = region,
    date = date,
    thumbnailImage = thumbnailImage
)



