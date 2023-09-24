package com.najudoryeong.mineme.core.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.najudoryeong.mineme.core.model.data.Couple
import com.najudoryeong.mineme.core.model.data.DarkThemeConfig
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.NewStory
import com.najudoryeong.mineme.core.model.data.Person
import com.najudoryeong.mineme.core.model.data.UserData
import com.najudoryeong.mineme.core.ui.PreviewParameterData.homeMainResource
import com.najudoryeong.mineme.core.ui.PreviewParameterData.homeMainResourceNoStory

class HomeMainResourcePreviewParameterProvider : PreviewParameterProvider<HomeMainResource> {
    override val values: Sequence<HomeMainResource> = sequenceOf(
        homeMainResource,homeMainResourceNoStory
    )
}

object PreviewParameterData {

    val homeMainResource = HomeMainResource(
        Couple(
            "알콩달콩",
            "2000-10-10",
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M"
            ),
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M"
            )
        ),
        NewStory(
            5000,
            "SL002",
            "2022-12-25",
            "https://via.placeholder.com/150"
        )
    )

    val homeMainResourceNoStory = HomeMainResource(
        Couple(
            "알콩달콩",
            "2000-10-10",
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M"
            ),
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M"
            )
        ),
        NewStory(
            -1,
            "",
            "",
            ""
        )
    )
}