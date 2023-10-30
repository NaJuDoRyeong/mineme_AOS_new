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

package com.najudoryeong.mineme.core.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.najudoryeong.mineme.core.model.data.Couple
import com.najudoryeong.mineme.core.model.data.HomeMainResource
import com.najudoryeong.mineme.core.model.data.NewStory
import com.najudoryeong.mineme.core.model.data.Person
import com.najudoryeong.mineme.core.ui.PreviewParameterData.homeMainResource
import com.najudoryeong.mineme.core.ui.PreviewParameterData.homeMainResourceNoStory

class HomeMainResourcePreviewParameterProvider : PreviewParameterProvider<HomeMainResource> {
    override val values: Sequence<HomeMainResource> = sequenceOf(
        homeMainResource,
        homeMainResourceNoStory,
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
                "M",
            ),
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M",
            ),
        ),
        NewStory(
            5000,
            "SL002",
            "2022-12-25",
            "https://via.placeholder.com/150",
        ),
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
                "M",
            ),
            Person(
                "https://via.placeholder.com/150",
                "김도우",
                "나는 도우",
                "dd_oo_uu",
                "1998-01-10",
                "M",
            ),
        ),
        NewStory(
            -1,
            "",
            "",
            "",
        ),
    )
}
