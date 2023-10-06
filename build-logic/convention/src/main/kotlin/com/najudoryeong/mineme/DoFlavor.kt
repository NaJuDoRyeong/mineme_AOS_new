package com.najudoryeong.mineme

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

/**
 * 플레이버는 앱의 다양한 버전을 구성하기 위한 기능
 * 데모 버전과 프로덕션 버전 같은 여러 버전의 앱을 한 소스 코드 베이스로 관리하려 할 때 유용
 */

@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType
}

/**
 * demo: 데모 목적으로 사용되는 앱 버전
 * prod: 실제 프로덕션용 앱 버전
 */
@Suppress("EnumEntryName")
enum class DoFlavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    demo(FlavorDimension.contentType, applicationIdSuffix = ".demo"),
    prod(FlavorDimension.contentType)
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: DoFlavor) -> Unit = {}
) {
    commonExtension.apply {
        flavorDimensions += FlavorDimension.contentType.name
        productFlavors {
            DoFlavor.values().forEach {
                create(it.name) {
                    dimension = it.dimension.name
                    flavorConfigurationBlock(this, it)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (it.applicationIdSuffix != null) {
                            applicationIdSuffix = it.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}
