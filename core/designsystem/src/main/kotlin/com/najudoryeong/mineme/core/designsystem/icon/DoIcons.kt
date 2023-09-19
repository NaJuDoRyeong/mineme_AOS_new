package com.najudoryeong.mineme.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.najudoryeong.mineme.core.designsystem.R




object DoIcons {

    // Bottom Img
    val Home = Icon.DrawableResourceIcon(R.drawable.home)
    val OnHome = Icon.DrawableResourceIcon(R.drawable.onhome)
    val Story = Icon.DrawableResourceIcon(R.drawable.story)
    val OnStory = Icon.DrawableResourceIcon(R.drawable.onstory)
    val Setting = Icon.DrawableResourceIcon(R.drawable.setting)
    val OnSetting = Icon.DrawableResourceIcon(R.drawable.onsetting)

    /** Home **/
    // Profile Img
    val default_me = Icon.DrawableResourceIcon(R.drawable.default_me)
    val default_mine = Icon.DrawableResourceIcon(R.drawable.default_mine)

    val heart = Icon.DrawableResourceIcon(R.drawable.heart)

    val no_story = Icon.DrawableResourceIcon(R.drawable.no_story)
}

sealed interface Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon
    data class DrawableResourceIcon(@DrawableRes val resourceId: Int) : Icon
}