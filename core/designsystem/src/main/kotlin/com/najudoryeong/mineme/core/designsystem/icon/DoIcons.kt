package com.najudoryeong.mineme.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
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

    // settings
    val setting_default = Icon.DrawableResourceIcon(R.drawable.setting_default)
    val setting_notification = Icon.DrawableResourceIcon(R.drawable.setting_notification)
    val setting_security = Icon.DrawableResourceIcon(R.drawable.setting_security)
}

sealed interface Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon
    data class DrawableResourceIcon(@DrawableRes val resourceId: Int) : Icon
}