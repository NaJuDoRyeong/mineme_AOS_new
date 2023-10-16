package com.najudoryeong.mineme.lint.designsystem

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

/**
 *  Lint에게 어떤 이슈들을 검출해야 하는지 알려준다.
 */
class DesignSystemIssueRegistry : IssueRegistry() {

    // 필요에 따라 여러 이슈 포함 가능
    override val issues: List<Issue> = listOf(DesignSystemDetector.ISSUE)

    override val api: Int = CURRENT_API

    override val minApi: Int = 12

    override val vendor: Vendor = Vendor(
        vendorName = "Mineme",
        feedbackUrl = "https://github.com/NaJuDoRyeong/mineme_AOS_new/issues",
        contact = "https://github.com/NaJuDoRyeong/mineme_AOS_new",
    )
}