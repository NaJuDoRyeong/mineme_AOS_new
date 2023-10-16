package com.najudoryeong.mineme.lint.designsystem

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UQualifiedReferenceExpression

class DesignSystemDetector : Detector(), Detector.UastScanner {


    /**
     * 검사하고자 하는 요소
     * UCallExpression: UAST에서 메서드 호출이나 함수 호출을 나타냄
     * UQualifiedReferenceExpression: UAST에서 한 객체나 클래스의 멤버에 대한 참조를 나타냄
     */
    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(
            UCallExpression::class.java,
            UQualifiedReferenceExpression::class.java,
        )
    }


    /**
     * UCallExpression와 UQualifiedReferenceExpression)에 대해 감지된 요소의 처리 방법을 정의
     */

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            // 권장 이름 제안

            // UCallExpression 요소를 방문할 때마다 호출
            override fun visitCallExpression(node: UCallExpression) {
                val name = node.methodName ?: return
                val preferredName = METHOD_NAMES[name] ?: return
                reportIssue(context, node, name, preferredName)
            }

            // UQualifiedReferenceExpression 요소를 방문할 때마다 호출
            override fun visitQualifiedReferenceExpression(node: UQualifiedReferenceExpression) {
                val name = node.receiver.asRenderString()
                val preferredName = RECEIVER_NAMES[name] ?: return
                reportIssue(context, node, name, preferredName)
            }
        }
    }

    companion object {

        // Issue 생성
        @JvmField
        val ISSUE: Issue = Issue.create(
            id = "DesignSystem",
            briefDescription = "Design system",
            explanation = "This check highlights calls in code that use Compose Material " +
                    "composables instead of equivalents from the Mineme design system " +
                    "module.",
            category = Category.CUSTOM_LINT_CHECKS,
            priority = 7,
            severity = Severity.ERROR,
            implementation = Implementation(
                DesignSystemDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )


        // 권장 이름 Map
        val METHOD_NAMES = mapOf(
            "MaterialTheme" to "DoTheme",
            "Button" to "DoButton",
            "OutlinedButton" to "DoOutlinedButton",
            "TextButton" to "DoTextButton",
            "FilterChip" to "DoFilterChip",
            "ElevatedFilterChip" to "DoFilterChip",
            "NavigationBar" to "DoNavigationBar",
            "NavigationBarItem" to "DoNavigationBarItem",
            "NavigationRail" to "DoNavigationRail",
            "NavigationRailItem" to "DoNavigationRailItem",
            "TabRow" to "DoTabRow",
            "Tab" to "DoTab",
            "IconToggleButton" to "DoIconToggleButton",
            "FilledIconToggleButton" to "DoIconToggleButton",
            "FilledTonalIconToggleButton" to "DoIconToggleButton",
            "OutlinedIconToggleButton" to "DoIconToggleButton",
            "CenterAlignedTopAppBar" to "DoTopAppBar",
            "SmallTopAppBar" to "DoTopAppBar",
            "MediumTopAppBar" to "DoTopAppBar",
            "LargeTopAppBar" to "DoTopAppBar",
        )
        val RECEIVER_NAMES = mapOf(
            "Icons" to "DoIcons",
        )


        //  코드 내에서 문제점을 발견할 경우 Lint에 해당 이슈를 보고
        fun reportIssue(
            context: JavaContext,
            node: UElement,
            name: String,
            preferredName: String,
        ) {
            context.report(
                ISSUE,
                node,
                context.getLocation(node),
                "Using $name instead of $preferredName",
            )
        }
    }
}