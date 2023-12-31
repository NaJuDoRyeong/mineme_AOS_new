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

package com.najudoryeong.mineme.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.najudoryeong.mineme.core.designsystem.R

object DoIcons {

    // Bottom Img
    val Home = Icon.DrawableResourceIcon(R.drawable.home)
    val OnHome = Icon.DrawableResourceIcon(R.drawable.onhome)
    val Story = Icon.DrawableResourceIcon(R.drawable.story)
    val OnStory = Icon.DrawableResourceIcon(R.drawable.onstory)
    val settings = Icon.DrawableResourceIcon(R.drawable.settings)
    val OnSettings = Icon.DrawableResourceIcon(R.drawable.onsettings)

    /** Home **/
    // Profile Img
    val default_me = Icon.DrawableResourceIcon(R.drawable.default_me)
    val default_mine = Icon.DrawableResourceIcon(R.drawable.default_mine)

    val heart = Icon.DrawableResourceIcon(R.drawable.heart)

    val no_story = Icon.DrawableResourceIcon(R.drawable.no_story)

    val top_region = Icon.DrawableResourceIcon(R.drawable.top_region)
    val top_story = Icon.DrawableResourceIcon(R.drawable.top_story)

    val no_story_inStory = Icon.DrawableResourceIcon(R.drawable.no_story_instory)
    val write_story = Icon.DrawableResourceIcon(R.drawable.writestory)

    val ArrowBack = Icons.Rounded.ArrowBack
    val ArrowDown = Icons.Default.ArrowDropDown

    // settings
    val setting_default = Icon.DrawableResourceIcon(R.drawable.setting_default)
    val setting_notification = Icon.DrawableResourceIcon(R.drawable.setting_notification)
    val setting_security = Icon.DrawableResourceIcon(R.drawable.setting_security)
}

@Composable
fun OnHomeIcon() {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(R.drawable.onhome_custom_part1),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary,
        )
        Icon(
            painter = painterResource(R.drawable.onhome_custom_part2),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
        Icon(
            painter = painterResource(R.drawable.onhome_custom_part3),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun OnStoryIcon() {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(R.drawable.onstory_custom_part1),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary,
        )

        Icon(
            painter = painterResource(R.drawable.onstory_custom_part2),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )

        Icon(
            painter = painterResource(R.drawable.onstory_custom_part3),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )

        Icon(
            painter = painterResource(R.drawable.onstory_custom_part4),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )

        Icon(
            painter = painterResource(R.drawable.onstory_custom_part5),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun OnSettingsIcon() {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(R.drawable.onsettings_custom_part1),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary,
        )
        Icon(
            painter = painterResource(R.drawable.onsettings_custom_part2),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )
        Icon(
            painter = painterResource(R.drawable.onsettings_custom_part3),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )
        Icon(
            painter = painterResource(R.drawable.onsettings_custom_part4),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

sealed interface Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon
    data class DrawableResourceIcon(@DrawableRes val resourceId: Int) : Icon
}
