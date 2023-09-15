package com.najudoryeong.mineme.core.designsystem.icon


import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


public val Icons.Rounded.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(
            name = "Home", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFB0B0B1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(21.2675f, 9.5573f)
                    lineTo(14.9467f, 3.2356f)
                    curveTo(14.1644f, 2.4556f, 13.1047f, 2.0176f, 12.0f, 2.0176f)
                    curveTo(10.8953f, 2.0176f, 9.8356f, 2.4556f, 9.0533f, 3.2356f)
                    lineTo(2.7325f, 9.5573f)
                    curveTo(2.4995f, 9.7887f, 2.3148f, 10.0642f, 2.1891f, 10.3676f)
                    curveTo(2.0633f, 10.671f, 1.9991f, 10.9963f, 2.0f, 11.3248f)
                    verticalLineTo(19.5056f)
                    curveTo(2.0f, 20.1686f, 2.2634f, 20.8045f, 2.7322f, 21.2734f)
                    curveTo(3.2011f, 21.7422f, 3.837f, 22.0056f, 4.5f, 22.0056f)
                    horizontalLineTo(19.5f)
                    curveTo(20.1631f, 22.0056f, 20.7989f, 21.7422f, 21.2678f, 21.2734f)
                    curveTo(21.7366f, 20.8045f, 22.0f, 20.1686f, 22.0f, 19.5056f)
                    verticalLineTo(11.3248f)
                    curveTo(22.0009f, 10.9963f, 21.9367f, 10.671f, 21.8109f, 10.3676f)
                    curveTo(21.6852f, 10.0642f, 21.5005f, 9.7887f, 21.2675f, 9.5573f)
                    close()
                    moveTo(14.5f, 20.3389f)
                    horizontalLineTo(9.5f)
                    verticalLineTo(17.0606f)
                    curveTo(9.5f, 16.3976f, 9.7634f, 15.7617f, 10.2322f, 15.2928f)
                    curveTo(10.7011f, 14.824f, 11.337f, 14.5606f, 12.0f, 14.5606f)
                    curveTo(12.6631f, 14.5606f, 13.2989f, 14.824f, 13.7678f, 15.2928f)
                    curveTo(14.2366f, 15.7617f, 14.5f, 16.3976f, 14.5f, 17.0606f)
                    verticalLineTo(20.3389f)
                    close()
                    moveTo(20.3333f, 19.5056f)
                    curveTo(20.3333f, 19.7266f, 20.2455f, 19.9386f, 20.0893f, 20.0949f)
                    curveTo(19.933f, 20.2511f, 19.721f, 20.3389f, 19.5f, 20.3389f)
                    horizontalLineTo(16.1667f)
                    verticalLineTo(17.0606f)
                    curveTo(16.1667f, 15.9555f, 15.7277f, 14.8957f, 14.9463f, 14.1143f)
                    curveTo(14.1649f, 13.3329f, 13.1051f, 12.8939f, 12.0f, 12.8939f)
                    curveTo(10.8949f, 12.8939f, 9.8351f, 13.3329f, 9.0537f, 14.1143f)
                    curveTo(8.2723f, 14.8957f, 7.8333f, 15.9555f, 7.8333f, 17.0606f)
                    verticalLineTo(20.3389f)
                    horizontalLineTo(4.5f)
                    curveTo(4.279f, 20.3389f, 4.067f, 20.2511f, 3.9107f, 20.0949f)
                    curveTo(3.7545f, 19.9386f, 3.6667f, 19.7266f, 3.6667f, 19.5056f)
                    verticalLineTo(11.3248f)
                    curveTo(3.6674f, 11.1039f, 3.7552f, 10.8923f, 3.9108f, 10.7356f)
                    lineTo(10.2317f, 4.4164f)
                    curveTo(10.7014f, 3.9489f, 11.3372f, 3.6864f, 12.0f, 3.6864f)
                    curveTo(12.6628f, 3.6864f, 13.2986f, 3.9489f, 13.7683f, 4.4164f)
                    lineTo(20.0892f, 10.7381f)
                    curveTo(20.2442f, 10.8941f, 20.3319f, 11.1048f, 20.3333f, 11.3248f)
                    verticalLineTo(19.5056f)
                    close()
                }
            }
        }
            .build()
        return _home!!
    }

private var _home: ImageVector? = null

public val Icons.Rounded.HomeBorder: ImageVector
    get() {
        if (_homeborder != null) {
            return _homeborder!!
        }
        _homeborder = Builder(
            name = "Homeborder", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF8BD0F6)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(10.6364f, 3.0f)
                    horizontalLineTo(11.7273f)
                    horizontalLineTo(13.3636f)
                    lineTo(21.0f, 10.6364f)
                    verticalLineTo(21.0f)
                    horizontalLineTo(3.0f)
                    verticalLineTo(10.6364f)
                    lineTo(10.6364f, 3.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFFDB94)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(16.0f, 21.0f)
                    curveTo(16.0f, 18.6667f, 15.143f, 14.0f, 11.7147f, 14.0f)
                    curveTo(8.2863f, 14.0f, 7.8373f, 18.6667f, 8.0414f, 21.0f)
                    horizontalLineTo(16.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF191919)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(21.2675f, 9.5573f)
                    lineTo(14.9467f, 3.2356f)
                    curveTo(14.1644f, 2.4556f, 13.1047f, 2.0176f, 12.0f, 2.0176f)
                    curveTo(10.8953f, 2.0176f, 9.8356f, 2.4556f, 9.0533f, 3.2356f)
                    lineTo(2.7325f, 9.5573f)
                    curveTo(2.4995f, 9.7887f, 2.3148f, 10.0642f, 2.1891f, 10.3676f)
                    curveTo(2.0633f, 10.671f, 1.9991f, 10.9963f, 2.0f, 11.3248f)
                    verticalLineTo(19.5056f)
                    curveTo(2.0f, 20.1686f, 2.2634f, 20.8045f, 2.7322f, 21.2734f)
                    curveTo(3.2011f, 21.7422f, 3.837f, 22.0056f, 4.5f, 22.0056f)
                    horizontalLineTo(19.5f)
                    curveTo(20.1631f, 22.0056f, 20.7989f, 21.7422f, 21.2678f, 21.2734f)
                    curveTo(21.7366f, 20.8045f, 22.0f, 20.1686f, 22.0f, 19.5056f)
                    verticalLineTo(11.3248f)
                    curveTo(22.0009f, 10.9963f, 21.9367f, 10.671f, 21.8109f, 10.3676f)
                    curveTo(21.6852f, 10.0642f, 21.5005f, 9.7887f, 21.2675f, 9.5573f)
                    close()
                    moveTo(14.5f, 20.3389f)
                    horizontalLineTo(9.5f)
                    verticalLineTo(17.0606f)
                    curveTo(9.5f, 16.3976f, 9.7634f, 15.7617f, 10.2322f, 15.2928f)
                    curveTo(10.7011f, 14.824f, 11.337f, 14.5606f, 12.0f, 14.5606f)
                    curveTo(12.6631f, 14.5606f, 13.2989f, 14.824f, 13.7678f, 15.2928f)
                    curveTo(14.2366f, 15.7617f, 14.5f, 16.3976f, 14.5f, 17.0606f)
                    verticalLineTo(20.3389f)
                    close()
                    moveTo(20.3333f, 19.5056f)
                    curveTo(20.3333f, 19.7266f, 20.2455f, 19.9386f, 20.0893f, 20.0949f)
                    curveTo(19.933f, 20.2511f, 19.721f, 20.3389f, 19.5f, 20.3389f)
                    horizontalLineTo(16.1667f)
                    verticalLineTo(17.0606f)
                    curveTo(16.1667f, 15.9555f, 15.7277f, 14.8957f, 14.9463f, 14.1143f)
                    curveTo(14.1649f, 13.3329f, 13.1051f, 12.8939f, 12.0f, 12.8939f)
                    curveTo(10.8949f, 12.8939f, 9.8351f, 13.3329f, 9.0537f, 14.1143f)
                    curveTo(8.2723f, 14.8957f, 7.8333f, 15.9555f, 7.8333f, 17.0606f)
                    verticalLineTo(20.3389f)
                    horizontalLineTo(4.5f)
                    curveTo(4.279f, 20.3389f, 4.067f, 20.2511f, 3.9107f, 20.0949f)
                    curveTo(3.7545f, 19.9386f, 3.6667f, 19.7266f, 3.6667f, 19.5056f)
                    verticalLineTo(11.3248f)
                    curveTo(3.6674f, 11.1039f, 3.7552f, 10.8923f, 3.9108f, 10.7356f)
                    lineTo(10.2317f, 4.4164f)
                    curveTo(10.7014f, 3.9489f, 11.3372f, 3.6864f, 12.0f, 3.6864f)
                    curveTo(12.6628f, 3.6864f, 13.2986f, 3.9489f, 13.7683f, 4.4164f)
                    lineTo(20.0892f, 10.7381f)
                    curveTo(20.2442f, 10.8941f, 20.3319f, 11.1048f, 20.3333f, 11.3248f)
                    verticalLineTo(19.5056f)
                    close()
                }
            }
        }
            .build()
        return _homeborder!!
    }

private var _homeborder: ImageVector? = null


public val Icons.Rounded.Setting: ImageVector
    get() {
        if (_setting != null) {
            return _setting!!
        }
        _setting = Builder(
            name = "Setting", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF8BD0F6)), stroke = SolidColor(Color(0xFF191919)),
                    strokeLineWidth = 1.7f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                    NonZero
                ) {
                    moveTo(18.1666f, 14.5002f)
                    curveTo(18.0557f, 14.7515f, 18.0226f, 15.0303f, 18.0716f, 15.3007f)
                    curveTo(18.1206f, 15.571f, 18.2495f, 15.8204f, 18.4416f, 16.0168f)
                    lineTo(18.4916f, 16.0668f)
                    curveTo(18.6465f, 16.2216f, 18.7695f, 16.4054f, 18.8534f, 16.6078f)
                    curveTo(18.9372f, 16.8101f, 18.9804f, 17.027f, 18.9804f, 17.246f)
                    curveTo(18.9804f, 17.465f, 18.9372f, 17.6819f, 18.8534f, 17.8842f)
                    curveTo(18.7695f, 18.0866f, 18.6465f, 18.2704f, 18.4916f, 18.4252f)
                    curveTo(18.3368f, 18.5801f, 18.153f, 18.7031f, 17.9507f, 18.7869f)
                    curveTo(17.7483f, 18.8708f, 17.5314f, 18.914f, 17.3124f, 18.914f)
                    curveTo(17.0934f, 18.914f, 16.8765f, 18.8708f, 16.6742f, 18.7869f)
                    curveTo(16.4719f, 18.7031f, 16.288f, 18.5801f, 16.1333f, 18.4252f)
                    lineTo(16.0833f, 18.3752f)
                    curveTo(15.8869f, 18.183f, 15.6374f, 18.0542f, 15.3671f, 18.0052f)
                    curveTo(15.0967f, 17.9561f, 14.8179f, 17.9892f, 14.5666f, 18.1002f)
                    curveTo(14.3201f, 18.2058f, 14.1099f, 18.3812f, 13.9618f, 18.6048f)
                    curveTo(13.8138f, 18.8284f, 13.7343f, 19.0903f, 13.7333f, 19.3585f)
                    verticalLineTo(19.5002f)
                    curveTo(13.7333f, 19.9422f, 13.5577f, 20.3661f, 13.2451f, 20.6787f)
                    curveTo(12.9325f, 20.9912f, 12.5086f, 21.1668f, 12.0666f, 21.1668f)
                    curveTo(11.6246f, 21.1668f, 11.2006f, 20.9912f, 10.8881f, 20.6787f)
                    curveTo(10.5755f, 20.3661f, 10.3999f, 19.9422f, 10.3999f, 19.5002f)
                    verticalLineTo(19.4252f)
                    curveTo(10.3935f, 19.1493f, 10.3042f, 18.8818f, 10.1437f, 18.6574f)
                    curveTo(9.9832f, 18.433f, 9.7589f, 18.2621f, 9.4999f, 18.1668f)
                    curveTo(9.2486f, 18.0559f, 8.9698f, 18.0228f, 8.6994f, 18.0718f)
                    curveTo(8.4291f, 18.1208f, 8.1797f, 18.2497f, 7.9833f, 18.4418f)
                    lineTo(7.9332f, 18.4918f)
                    curveTo(7.7785f, 18.6468f, 7.5946f, 18.7697f, 7.3923f, 18.8536f)
                    curveTo(7.19f, 18.9375f, 6.9731f, 18.9806f, 6.7541f, 18.9806f)
                    curveTo(6.5351f, 18.9806f, 6.3182f, 18.9375f, 6.1158f, 18.8536f)
                    curveTo(5.9135f, 18.7697f, 5.7297f, 18.6468f, 5.5749f, 18.4918f)
                    curveTo(5.42f, 18.337f, 5.297f, 18.1532f, 5.2132f, 17.9509f)
                    curveTo(5.1293f, 17.7486f, 5.0861f, 17.5317f, 5.0861f, 17.3127f)
                    curveTo(5.0861f, 17.0936f, 5.1293f, 16.8768f, 5.2132f, 16.6744f)
                    curveTo(5.297f, 16.4721f, 5.42f, 16.2883f, 5.5749f, 16.1335f)
                    lineTo(5.6249f, 16.0835f)
                    curveTo(5.817f, 15.8871f, 5.9459f, 15.6376f, 5.9949f, 15.3673f)
                    curveTo(6.0439f, 15.097f, 6.0108f, 14.8182f, 5.8999f, 14.5668f)
                    curveTo(5.7943f, 14.3204f, 5.6189f, 14.1101f, 5.3953f, 13.9621f)
                    curveTo(5.1717f, 13.814f, 4.9097f, 13.7346f, 4.6416f, 13.7335f)
                    horizontalLineTo(4.4999f)
                    curveTo(4.0579f, 13.7335f, 3.634f, 13.5579f, 3.3214f, 13.2453f)
                    curveTo(3.0089f, 12.9328f, 2.8333f, 12.5089f, 2.8333f, 12.0668f)
                    curveTo(2.8333f, 11.6248f, 3.0089f, 11.2009f, 3.3214f, 10.8883f)
                    curveTo(3.634f, 10.5758f, 4.0579f, 10.4002f, 4.4999f, 10.4002f)
                    horizontalLineTo(4.5749f)
                    curveTo(4.8507f, 10.3937f, 5.1183f, 10.3044f, 5.3427f, 10.1439f)
                    curveTo(5.5671f, 9.9834f, 5.738f, 9.7591f, 5.8333f, 9.5002f)
                    curveTo(5.9442f, 9.2488f, 5.9773f, 8.97f, 5.9283f, 8.6997f)
                    curveTo(5.8792f, 8.4293f, 5.7504f, 8.1799f, 5.5582f, 7.9835f)
                    lineTo(5.5083f, 7.9335f)
                    curveTo(5.3533f, 7.7787f, 5.2304f, 7.5949f, 5.1465f, 7.3926f)
                    curveTo(5.0626f, 7.1902f, 5.0194f, 6.9734f, 5.0194f, 6.7543f)
                    curveTo(5.0194f, 6.5353f, 5.0626f, 6.3184f, 5.1465f, 6.1161f)
                    curveTo(5.2304f, 5.9138f, 5.3533f, 5.7299f, 5.5083f, 5.5752f)
                    curveTo(5.663f, 5.4202f, 5.8468f, 5.2973f, 6.0492f, 5.2134f)
                    curveTo(6.2515f, 5.1295f, 6.4684f, 5.0863f, 6.6874f, 5.0863f)
                    curveTo(6.9064f, 5.0863f, 7.1233f, 5.1295f, 7.3257f, 5.2134f)
                    curveTo(7.528f, 5.2973f, 7.7118f, 5.4202f, 7.8666f, 5.5752f)
                    lineTo(7.9166f, 5.6252f)
                    curveTo(8.113f, 5.8173f, 8.3624f, 5.9461f, 8.6328f, 5.9952f)
                    curveTo(8.9031f, 6.0442f, 9.1819f, 6.0111f, 9.4333f, 5.9002f)
                    horizontalLineTo(9.4999f)
                    curveTo(9.7464f, 5.7945f, 9.9566f, 5.6191f, 10.1047f, 5.3955f)
                    curveTo(10.2527f, 5.172f, 10.3322f, 4.91f, 10.3333f, 4.6418f)
                    verticalLineTo(4.5002f)
                    curveTo(10.3333f, 4.0581f, 10.5088f, 3.6342f, 10.8214f, 3.3217f)
                    curveTo(11.134f, 3.0091f, 11.5579f, 2.8335f, 11.9999f, 2.8335f)
                    curveTo(12.4419f, 2.8335f, 12.8659f, 3.0091f, 13.1784f, 3.3217f)
                    curveTo(13.491f, 3.6342f, 13.6666f, 4.0581f, 13.6666f, 4.5002f)
                    verticalLineTo(4.5752f)
                    curveTo(13.6677f, 4.8433f, 13.7471f, 5.1053f, 13.8952f, 5.3289f)
                    curveTo(14.0432f, 5.5525f, 14.2534f, 5.7279f, 14.4999f, 5.8335f)
                    curveTo(14.7513f, 5.9444f, 15.0301f, 5.9775f, 15.3004f, 5.9285f)
                    curveTo(15.5707f, 5.8795f, 15.8202f, 5.7506f, 16.0166f, 5.5585f)
                    lineTo(16.0666f, 5.5085f)
                    curveTo(16.2214f, 5.3535f, 16.4052f, 5.2306f, 16.6075f, 5.1467f)
                    curveTo(16.8098f, 5.0629f, 17.0267f, 5.0197f, 17.2458f, 5.0197f)
                    curveTo(17.4648f, 5.0197f, 17.6817f, 5.0629f, 17.884f, 5.1467f)
                    curveTo(18.0863f, 5.2306f, 18.2701f, 5.3535f, 18.4249f, 5.5085f)
                    curveTo(18.5799f, 5.6633f, 18.7028f, 5.8471f, 18.7867f, 6.0494f)
                    curveTo(18.8706f, 6.2518f, 18.9137f, 6.4686f, 18.9137f, 6.6877f)
                    curveTo(18.9137f, 6.9067f, 18.8706f, 7.1236f, 18.7867f, 7.3259f)
                    curveTo(18.7028f, 7.5282f, 18.5799f, 7.712f, 18.4249f, 7.8668f)
                    lineTo(18.3749f, 7.9168f)
                    curveTo(18.1828f, 8.1132f, 18.0539f, 8.3627f, 18.0049f, 8.633f)
                    curveTo(17.9559f, 8.9033f, 17.989f, 9.1821f, 18.0999f, 9.4335f)
                    verticalLineTo(9.5002f)
                    curveTo(18.2056f, 9.7466f, 18.381f, 9.9568f, 18.6045f, 10.1049f)
                    curveTo(18.8281f, 10.253f, 19.0901f, 10.3324f, 19.3583f, 10.3335f)
                    horizontalLineTo(19.4999f)
                    curveTo(19.9419f, 10.3335f, 20.3659f, 10.5091f, 20.6784f, 10.8217f)
                    curveTo(20.991f, 11.1342f, 21.1666f, 11.5581f, 21.1666f, 12.0002f)
                    curveTo(21.1666f, 12.4422f, 20.991f, 12.8661f, 20.6784f, 13.1787f)
                    curveTo(20.3659f, 13.4912f, 19.9419f, 13.6668f, 19.4999f, 13.6668f)
                    horizontalLineTo(19.4249f)
                    curveTo(19.1568f, 13.6679f, 18.8948f, 13.7474f, 18.6712f, 13.8954f)
                    curveTo(18.4476f, 14.0435f, 18.2722f, 14.2537f, 18.1666f, 14.5002f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFFDB94)), stroke = SolidColor(Color(0xFF191919)),
                    strokeLineWidth = 1.7f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                    NonZero
                ) {
                    moveTo(12.0f, 14.5f)
                    curveTo(13.3807f, 14.5f, 14.5f, 13.3807f, 14.5f, 12.0f)
                    curveTo(14.5f, 10.6193f, 13.3807f, 9.5f, 12.0f, 9.5f)
                    curveTo(10.6193f, 9.5f, 9.5f, 10.6193f, 9.5f, 12.0f)
                    curveTo(9.5f, 13.3807f, 10.6193f, 14.5f, 12.0f, 14.5f)
                    close()
                }
            }
        }
            .build()
        return _setting!!
    }

private var _setting: ImageVector? = null

public val Icons.Rounded.SettingBorder: ImageVector
    get() {
        if (_settingborder != null) {
            return _settingborder!!
        }
        _settingborder = Builder(
            name = "Settingborder", defaultWidth = 24.0.dp, defaultHeight =
            24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFB0B0B1)),
                    strokeLineWidth = 1.7f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                    NonZero
                ) {
                    moveTo(18.1666f, 14.5002f)
                    curveTo(18.0557f, 14.7515f, 18.0226f, 15.0303f, 18.0716f, 15.3007f)
                    curveTo(18.1206f, 15.571f, 18.2495f, 15.8204f, 18.4416f, 16.0168f)
                    lineTo(18.4916f, 16.0668f)
                    curveTo(18.6465f, 16.2216f, 18.7695f, 16.4054f, 18.8534f, 16.6078f)
                    curveTo(18.9372f, 16.8101f, 18.9804f, 17.027f, 18.9804f, 17.246f)
                    curveTo(18.9804f, 17.465f, 18.9372f, 17.6819f, 18.8534f, 17.8842f)
                    curveTo(18.7695f, 18.0866f, 18.6465f, 18.2704f, 18.4916f, 18.4252f)
                    curveTo(18.3368f, 18.5801f, 18.153f, 18.7031f, 17.9507f, 18.7869f)
                    curveTo(17.7483f, 18.8708f, 17.5314f, 18.914f, 17.3124f, 18.914f)
                    curveTo(17.0934f, 18.914f, 16.8765f, 18.8708f, 16.6742f, 18.7869f)
                    curveTo(16.4719f, 18.7031f, 16.288f, 18.5801f, 16.1333f, 18.4252f)
                    lineTo(16.0833f, 18.3752f)
                    curveTo(15.8869f, 18.183f, 15.6374f, 18.0542f, 15.3671f, 18.0052f)
                    curveTo(15.0967f, 17.9561f, 14.8179f, 17.9892f, 14.5666f, 18.1002f)
                    curveTo(14.3201f, 18.2058f, 14.1099f, 18.3812f, 13.9618f, 18.6048f)
                    curveTo(13.8138f, 18.8284f, 13.7343f, 19.0903f, 13.7333f, 19.3585f)
                    verticalLineTo(19.5002f)
                    curveTo(13.7333f, 19.9422f, 13.5577f, 20.3661f, 13.2451f, 20.6787f)
                    curveTo(12.9325f, 20.9912f, 12.5086f, 21.1668f, 12.0666f, 21.1668f)
                    curveTo(11.6246f, 21.1668f, 11.2006f, 20.9912f, 10.8881f, 20.6787f)
                    curveTo(10.5755f, 20.3661f, 10.3999f, 19.9422f, 10.3999f, 19.5002f)
                    verticalLineTo(19.4252f)
                    curveTo(10.3935f, 19.1493f, 10.3042f, 18.8818f, 10.1437f, 18.6574f)
                    curveTo(9.9832f, 18.433f, 9.7589f, 18.2621f, 9.4999f, 18.1668f)
                    curveTo(9.2486f, 18.0559f, 8.9698f, 18.0228f, 8.6994f, 18.0718f)
                    curveTo(8.4291f, 18.1208f, 8.1797f, 18.2497f, 7.9833f, 18.4418f)
                    lineTo(7.9332f, 18.4918f)
                    curveTo(7.7785f, 18.6468f, 7.5946f, 18.7697f, 7.3923f, 18.8536f)
                    curveTo(7.19f, 18.9375f, 6.9731f, 18.9806f, 6.7541f, 18.9806f)
                    curveTo(6.5351f, 18.9806f, 6.3182f, 18.9375f, 6.1158f, 18.8536f)
                    curveTo(5.9135f, 18.7697f, 5.7297f, 18.6468f, 5.5749f, 18.4918f)
                    curveTo(5.42f, 18.337f, 5.297f, 18.1532f, 5.2132f, 17.9509f)
                    curveTo(5.1293f, 17.7486f, 5.0861f, 17.5317f, 5.0861f, 17.3127f)
                    curveTo(5.0861f, 17.0936f, 5.1293f, 16.8768f, 5.2132f, 16.6744f)
                    curveTo(5.297f, 16.4721f, 5.42f, 16.2883f, 5.5749f, 16.1335f)
                    lineTo(5.6249f, 16.0835f)
                    curveTo(5.817f, 15.8871f, 5.9459f, 15.6376f, 5.9949f, 15.3673f)
                    curveTo(6.0439f, 15.097f, 6.0108f, 14.8182f, 5.8999f, 14.5668f)
                    curveTo(5.7943f, 14.3204f, 5.6189f, 14.1101f, 5.3953f, 13.9621f)
                    curveTo(5.1717f, 13.814f, 4.9097f, 13.7346f, 4.6416f, 13.7335f)
                    horizontalLineTo(4.4999f)
                    curveTo(4.0579f, 13.7335f, 3.634f, 13.5579f, 3.3214f, 13.2453f)
                    curveTo(3.0089f, 12.9328f, 2.8333f, 12.5089f, 2.8333f, 12.0668f)
                    curveTo(2.8333f, 11.6248f, 3.0089f, 11.2009f, 3.3214f, 10.8883f)
                    curveTo(3.634f, 10.5758f, 4.0579f, 10.4002f, 4.4999f, 10.4002f)
                    horizontalLineTo(4.5749f)
                    curveTo(4.8507f, 10.3937f, 5.1183f, 10.3044f, 5.3427f, 10.1439f)
                    curveTo(5.5671f, 9.9834f, 5.738f, 9.7591f, 5.8333f, 9.5002f)
                    curveTo(5.9442f, 9.2488f, 5.9773f, 8.97f, 5.9283f, 8.6997f)
                    curveTo(5.8792f, 8.4293f, 5.7504f, 8.1799f, 5.5582f, 7.9835f)
                    lineTo(5.5083f, 7.9335f)
                    curveTo(5.3533f, 7.7787f, 5.2304f, 7.5949f, 5.1465f, 7.3926f)
                    curveTo(5.0626f, 7.1902f, 5.0194f, 6.9734f, 5.0194f, 6.7543f)
                    curveTo(5.0194f, 6.5353f, 5.0626f, 6.3184f, 5.1465f, 6.1161f)
                    curveTo(5.2304f, 5.9138f, 5.3533f, 5.7299f, 5.5083f, 5.5752f)
                    curveTo(5.663f, 5.4202f, 5.8468f, 5.2973f, 6.0492f, 5.2134f)
                    curveTo(6.2515f, 5.1295f, 6.4684f, 5.0863f, 6.6874f, 5.0863f)
                    curveTo(6.9064f, 5.0863f, 7.1233f, 5.1295f, 7.3257f, 5.2134f)
                    curveTo(7.528f, 5.2973f, 7.7118f, 5.4202f, 7.8666f, 5.5752f)
                    lineTo(7.9166f, 5.6252f)
                    curveTo(8.113f, 5.8173f, 8.3624f, 5.9461f, 8.6328f, 5.9952f)
                    curveTo(8.9031f, 6.0442f, 9.1819f, 6.0111f, 9.4333f, 5.9002f)
                    horizontalLineTo(9.4999f)
                    curveTo(9.7464f, 5.7945f, 9.9566f, 5.6191f, 10.1047f, 5.3955f)
                    curveTo(10.2527f, 5.172f, 10.3322f, 4.91f, 10.3333f, 4.6418f)
                    verticalLineTo(4.5002f)
                    curveTo(10.3333f, 4.0581f, 10.5088f, 3.6342f, 10.8214f, 3.3217f)
                    curveTo(11.134f, 3.0091f, 11.5579f, 2.8335f, 11.9999f, 2.8335f)
                    curveTo(12.4419f, 2.8335f, 12.8659f, 3.0091f, 13.1784f, 3.3217f)
                    curveTo(13.491f, 3.6342f, 13.6666f, 4.0581f, 13.6666f, 4.5002f)
                    verticalLineTo(4.5752f)
                    curveTo(13.6677f, 4.8433f, 13.7471f, 5.1053f, 13.8952f, 5.3289f)
                    curveTo(14.0432f, 5.5525f, 14.2534f, 5.7279f, 14.4999f, 5.8335f)
                    curveTo(14.7513f, 5.9444f, 15.0301f, 5.9775f, 15.3004f, 5.9285f)
                    curveTo(15.5707f, 5.8795f, 15.8202f, 5.7506f, 16.0166f, 5.5585f)
                    lineTo(16.0666f, 5.5085f)
                    curveTo(16.2214f, 5.3535f, 16.4052f, 5.2306f, 16.6075f, 5.1467f)
                    curveTo(16.8098f, 5.0629f, 17.0267f, 5.0197f, 17.2458f, 5.0197f)
                    curveTo(17.4648f, 5.0197f, 17.6817f, 5.0629f, 17.884f, 5.1467f)
                    curveTo(18.0863f, 5.2306f, 18.2701f, 5.3535f, 18.4249f, 5.5085f)
                    curveTo(18.5799f, 5.6633f, 18.7028f, 5.8471f, 18.7867f, 6.0494f)
                    curveTo(18.8706f, 6.2518f, 18.9137f, 6.4686f, 18.9137f, 6.6877f)
                    curveTo(18.9137f, 6.9067f, 18.8706f, 7.1236f, 18.7867f, 7.3259f)
                    curveTo(18.7028f, 7.5282f, 18.5799f, 7.712f, 18.4249f, 7.8668f)
                    lineTo(18.3749f, 7.9168f)
                    curveTo(18.1828f, 8.1132f, 18.0539f, 8.3627f, 18.0049f, 8.633f)
                    curveTo(17.9559f, 8.9033f, 17.989f, 9.1821f, 18.0999f, 9.4335f)
                    verticalLineTo(9.5002f)
                    curveTo(18.2056f, 9.7466f, 18.381f, 9.9568f, 18.6045f, 10.1049f)
                    curveTo(18.8281f, 10.253f, 19.0901f, 10.3324f, 19.3583f, 10.3335f)
                    horizontalLineTo(19.4999f)
                    curveTo(19.9419f, 10.3335f, 20.3659f, 10.5091f, 20.6784f, 10.8217f)
                    curveTo(20.991f, 11.1342f, 21.1666f, 11.5581f, 21.1666f, 12.0002f)
                    curveTo(21.1666f, 12.4422f, 20.991f, 12.8661f, 20.6784f, 13.1787f)
                    curveTo(20.3659f, 13.4912f, 19.9419f, 13.6668f, 19.4999f, 13.6668f)
                    horizontalLineTo(19.4249f)
                    curveTo(19.1568f, 13.6679f, 18.8948f, 13.7474f, 18.6712f, 13.8954f)
                    curveTo(18.4476f, 14.0435f, 18.2722f, 14.2537f, 18.1666f, 14.5002f)
                    verticalLineTo(14.5002f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFB0B0B1)),
                    strokeLineWidth = 1.7f, strokeLineCap = StrokeCap.Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType =
                    NonZero
                ) {
                    moveTo(12.0f, 14.5f)
                    curveTo(13.3807f, 14.5f, 14.5f, 13.3807f, 14.5f, 12.0f)
                    curveTo(14.5f, 10.6193f, 13.3807f, 9.5f, 12.0f, 9.5f)
                    curveTo(10.6193f, 9.5f, 9.5f, 10.6193f, 9.5f, 12.0f)
                    curveTo(9.5f, 13.3807f, 10.6193f, 14.5f, 12.0f, 14.5f)
                    close()
                }
            }
        }
            .build()
        return _settingborder!!
    }

private var _settingborder: ImageVector? = null


public val Icons.Rounded.Story: ImageVector
    get() {
        if (_story != null) {
            return _story!!
        }
        _story = Builder(
            name = "Story", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF8BD0F6)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(9.0f, 11.0f)
                lineTo(3.0f, 16.0f)
                verticalLineTo(5.5f)
                lineTo(4.5f, 3.0f)
                horizontalLineTo(18.5f)
                lineTo(21.0f, 4.5f)
                verticalLineTo(19.0f)
                lineTo(20.0f, 20.0f)
                lineTo(11.0f, 11.0f)
                horizontalLineTo(9.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFDB94)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(9.0f, 10.5f)
                lineTo(3.5f, 15.0f)
                lineTo(3.0f, 19.0f)
                lineTo(5.5f, 21.0f)
                horizontalLineTo(19.0f)
                lineTo(20.0f, 20.0f)
                lineTo(11.0f, 11.0f)
                lineTo(9.0f, 10.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFDB94)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(14.0f, 8.0f)
                arcToRelative(1.5f, 2.0f, 0.0f, true, false, 3.0f, 0.0f)
                arcToRelative(1.5f, 2.0f, 0.0f, true, false, -3.0f, 0.0f)
                close()
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF191919)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(17.8333f, 2.0f)
                    horizontalLineTo(6.1667f)
                    curveTo(5.062f, 2.0013f, 4.003f, 2.4407f, 3.2218f, 3.2218f)
                    curveTo(2.4407f, 4.003f, 2.0013f, 5.062f, 2.0f, 6.1667f)
                    lineTo(2.0f, 17.8333f)
                    curveTo(2.0013f, 18.938f, 2.4407f, 19.997f, 3.2218f, 20.7782f)
                    curveTo(4.003f, 21.5593f, 5.062f, 21.9987f, 6.1667f, 22.0f)
                    horizontalLineTo(17.8333f)
                    curveTo(18.938f, 21.9987f, 19.997f, 21.5593f, 20.7782f, 20.7782f)
                    curveTo(21.5593f, 19.997f, 21.9987f, 18.938f, 22.0f, 17.8333f)
                    verticalLineTo(6.1667f)
                    curveTo(21.9987f, 5.062f, 21.5593f, 4.003f, 20.7782f, 3.2218f)
                    curveTo(19.997f, 2.4407f, 18.938f, 2.0013f, 17.8333f, 2.0f)
                    verticalLineTo(2.0f)
                    close()
                    moveTo(6.1667f, 3.6667f)
                    horizontalLineTo(17.8333f)
                    curveTo(18.4964f, 3.6667f, 19.1323f, 3.9301f, 19.6011f, 4.3989f)
                    curveTo(20.0699f, 4.8677f, 20.3333f, 5.5036f, 20.3333f, 6.1667f)
                    verticalLineTo(17.8333f)
                    curveTo(20.3319f, 18.2046f, 20.2464f, 18.5707f, 20.0833f, 18.9042f)
                    lineTo(12.4475f, 11.2683f)
                    curveTo(12.0606f, 10.8813f, 11.6012f, 10.5743f, 11.0956f, 10.3648f)
                    curveTo(10.59f, 10.1554f, 10.0481f, 10.0476f, 9.5008f, 10.0476f)
                    curveTo(8.9536f, 10.0476f, 8.4117f, 10.1554f, 7.9061f, 10.3648f)
                    curveTo(7.4005f, 10.5743f, 6.9411f, 10.8813f, 6.5542f, 11.2683f)
                    lineTo(3.6667f, 14.155f)
                    verticalLineTo(6.1667f)
                    curveTo(3.6667f, 5.5036f, 3.9301f, 4.8677f, 4.3989f, 4.3989f)
                    curveTo(4.8677f, 3.9301f, 5.5036f, 3.6667f, 6.1667f, 3.6667f)
                    close()
                    moveTo(6.1667f, 20.3333f)
                    curveTo(5.5036f, 20.3333f, 4.8677f, 20.0699f, 4.3989f, 19.6011f)
                    curveTo(3.9301f, 19.1323f, 3.6667f, 18.4964f, 3.6667f, 17.8333f)
                    verticalLineTo(16.5117f)
                    lineTo(7.7317f, 12.4467f)
                    curveTo(7.9638f, 12.2144f, 8.2395f, 12.0301f, 8.5429f, 11.9043f)
                    curveTo(8.8463f, 11.7786f, 9.1716f, 11.7139f, 9.5f, 11.7139f)
                    curveTo(9.8284f, 11.7139f, 10.1537f, 11.7786f, 10.4571f, 11.9043f)
                    curveTo(10.7605f, 12.0301f, 11.0362f, 12.2144f, 11.2683f, 12.4467f)
                    lineTo(18.9042f, 20.0833f)
                    curveTo(18.5707f, 20.2464f, 18.2046f, 20.3319f, 17.8333f, 20.3333f)
                    horizontalLineTo(6.1667f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF191919)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(15.3334f, 10.7498f)
                    curveTo(15.9103f, 10.7498f, 16.4742f, 10.5788f, 16.9538f, 10.2583f)
                    curveTo(17.4335f, 9.9378f, 17.8073f, 9.4823f, 18.0281f, 8.9493f)
                    curveTo(18.2488f, 8.4164f, 18.3066f, 7.8299f, 18.194f, 7.2642f)
                    curveTo(18.0815f, 6.6984f, 17.8037f, 6.1787f, 17.3958f, 5.7708f)
                    curveTo(16.9879f, 5.3629f, 16.4682f, 5.0851f, 15.9024f, 4.9725f)
                    curveTo(15.3366f, 4.86f, 14.7502f, 4.9178f, 14.2173f, 5.1385f)
                    curveTo(13.6843f, 5.3593f, 13.2288f, 5.7331f, 12.9083f, 6.2128f)
                    curveTo(12.5878f, 6.6924f, 12.4167f, 7.2563f, 12.4167f, 7.8332f)
                    curveTo(12.4167f, 8.6067f, 12.724f, 9.3486f, 13.271f, 9.8956f)
                    curveTo(13.818f, 10.4425f, 14.5599f, 10.7498f, 15.3334f, 10.7498f)
                    close()
                    moveTo(15.3334f, 6.5832f)
                    curveTo(15.5806f, 6.5832f, 15.8223f, 6.6565f, 16.0279f, 6.7938f)
                    curveTo(16.2334f, 6.9312f, 16.3937f, 7.1264f, 16.4883f, 7.3548f)
                    curveTo(16.5829f, 7.5832f, 16.6076f, 7.8346f, 16.5594f, 8.077f)
                    curveTo(16.5112f, 8.3195f, 16.3921f, 8.5422f, 16.2173f, 8.7171f)
                    curveTo(16.0425f, 8.8919f, 15.8198f, 9.0109f, 15.5773f, 9.0591f)
                    curveTo(15.3348f, 9.1074f, 15.0835f, 9.0826f, 14.8551f, 8.988f)
                    curveTo(14.6267f, 8.8934f, 14.4314f, 8.7332f, 14.2941f, 8.5276f)
                    curveTo(14.1567f, 8.3221f, 14.0834f, 8.0804f, 14.0834f, 7.8332f)
                    curveTo(14.0834f, 7.5016f, 14.2151f, 7.1837f, 14.4495f, 6.9493f)
                    curveTo(14.684f, 6.7149f, 15.0019f, 6.5832f, 15.3334f, 6.5832f)
                    close()
                }
            }
        }
            .build()
        return _story!!
    }

private var _story: ImageVector? = null


public val Icons.Rounded.Storyborder: ImageVector
    get() {
        if (_storyborder != null) {
            return _storyborder!!
        }
        _storyborder = Builder(
            name = "Storyborder", defaultWidth = 24.0.dp, defaultHeight =
            24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF8BD0F6)), stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(9.0f, 11.0f)
                lineTo(3.0f, 16.0f)
                verticalLineTo(5.5f)
                lineTo(4.5f, 3.0f)
                horizontalLineTo(18.5f)
                lineTo(21.0f, 4.5f)
                verticalLineTo(19.0f)
                lineTo(20.0f, 20.0f)
                lineTo(11.0f, 11.0f)
                horizontalLineTo(9.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFDB94)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(9.0f, 10.5f)
                lineTo(3.5f, 15.0f)
                lineTo(3.0f, 19.0f)
                lineTo(5.5f, 21.0f)
                horizontalLineTo(19.0f)
                lineTo(20.0f, 20.0f)
                lineTo(11.0f, 11.0f)
                lineTo(9.0f, 10.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFDB94)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(14.0f, 8.0f)
                arcToRelative(1.5f, 2.0f, 0.0f, true, false, 3.0f, 0.0f)
                arcToRelative(1.5f, 2.0f, 0.0f, true, false, -3.0f, 0.0f)
                close()
            }
            group {
                path(
                    fill = SolidColor(Color(0xFF191919)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(17.8333f, 2.0f)
                    horizontalLineTo(6.1667f)
                    curveTo(5.062f, 2.0013f, 4.003f, 2.4407f, 3.2218f, 3.2218f)
                    curveTo(2.4407f, 4.003f, 2.0013f, 5.062f, 2.0f, 6.1667f)
                    lineTo(2.0f, 17.8333f)
                    curveTo(2.0013f, 18.938f, 2.4407f, 19.997f, 3.2218f, 20.7782f)
                    curveTo(4.003f, 21.5593f, 5.062f, 21.9987f, 6.1667f, 22.0f)
                    horizontalLineTo(17.8333f)
                    curveTo(18.938f, 21.9987f, 19.997f, 21.5593f, 20.7782f, 20.7782f)
                    curveTo(21.5593f, 19.997f, 21.9987f, 18.938f, 22.0f, 17.8333f)
                    verticalLineTo(6.1667f)
                    curveTo(21.9987f, 5.062f, 21.5593f, 4.003f, 20.7782f, 3.2218f)
                    curveTo(19.997f, 2.4407f, 18.938f, 2.0013f, 17.8333f, 2.0f)
                    verticalLineTo(2.0f)
                    close()
                    moveTo(6.1667f, 3.6667f)
                    horizontalLineTo(17.8333f)
                    curveTo(18.4964f, 3.6667f, 19.1323f, 3.9301f, 19.6011f, 4.3989f)
                    curveTo(20.0699f, 4.8677f, 20.3333f, 5.5036f, 20.3333f, 6.1667f)
                    verticalLineTo(17.8333f)
                    curveTo(20.3319f, 18.2046f, 20.2464f, 18.5707f, 20.0833f, 18.9042f)
                    lineTo(12.4475f, 11.2683f)
                    curveTo(12.0606f, 10.8813f, 11.6012f, 10.5743f, 11.0956f, 10.3648f)
                    curveTo(10.59f, 10.1554f, 10.0481f, 10.0476f, 9.5008f, 10.0476f)
                    curveTo(8.9536f, 10.0476f, 8.4117f, 10.1554f, 7.9061f, 10.3648f)
                    curveTo(7.4005f, 10.5743f, 6.9411f, 10.8813f, 6.5542f, 11.2683f)
                    lineTo(3.6667f, 14.155f)
                    verticalLineTo(6.1667f)
                    curveTo(3.6667f, 5.5036f, 3.9301f, 4.8677f, 4.3989f, 4.3989f)
                    curveTo(4.8677f, 3.9301f, 5.5036f, 3.6667f, 6.1667f, 3.6667f)
                    close()
                    moveTo(6.1667f, 20.3333f)
                    curveTo(5.5036f, 20.3333f, 4.8677f, 20.0699f, 4.3989f, 19.6011f)
                    curveTo(3.9301f, 19.1323f, 3.6667f, 18.4964f, 3.6667f, 17.8333f)
                    verticalLineTo(16.5117f)
                    lineTo(7.7317f, 12.4467f)
                    curveTo(7.9638f, 12.2144f, 8.2395f, 12.0301f, 8.5429f, 11.9043f)
                    curveTo(8.8463f, 11.7786f, 9.1716f, 11.7139f, 9.5f, 11.7139f)
                    curveTo(9.8284f, 11.7139f, 10.1537f, 11.7786f, 10.4571f, 11.9043f)
                    curveTo(10.7605f, 12.0301f, 11.0362f, 12.2144f, 11.2683f, 12.4467f)
                    lineTo(18.9042f, 20.0833f)
                    curveTo(18.5707f, 20.2464f, 18.2046f, 20.3319f, 17.8333f, 20.3333f)
                    horizontalLineTo(6.1667f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF191919)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(15.3334f, 10.7498f)
                    curveTo(15.9103f, 10.7498f, 16.4742f, 10.5788f, 16.9538f, 10.2583f)
                    curveTo(17.4335f, 9.9378f, 17.8073f, 9.4823f, 18.0281f, 8.9493f)
                    curveTo(18.2488f, 8.4164f, 18.3066f, 7.8299f, 18.194f, 7.2642f)
                    curveTo(18.0815f, 6.6984f, 17.8037f, 6.1787f, 17.3958f, 5.7708f)
                    curveTo(16.9879f, 5.3629f, 16.4682f, 5.0851f, 15.9024f, 4.9725f)
                    curveTo(15.3366f, 4.86f, 14.7502f, 4.9178f, 14.2173f, 5.1385f)
                    curveTo(13.6843f, 5.3593f, 13.2288f, 5.7331f, 12.9083f, 6.2128f)
                    curveTo(12.5878f, 6.6924f, 12.4167f, 7.2563f, 12.4167f, 7.8332f)
                    curveTo(12.4167f, 8.6067f, 12.724f, 9.3486f, 13.271f, 9.8956f)
                    curveTo(13.818f, 10.4425f, 14.5599f, 10.7498f, 15.3334f, 10.7498f)
                    close()
                    moveTo(15.3334f, 6.5832f)
                    curveTo(15.5806f, 6.5832f, 15.8223f, 6.6565f, 16.0279f, 6.7938f)
                    curveTo(16.2334f, 6.9312f, 16.3937f, 7.1264f, 16.4883f, 7.3548f)
                    curveTo(16.5829f, 7.5832f, 16.6076f, 7.8346f, 16.5594f, 8.077f)
                    curveTo(16.5112f, 8.3195f, 16.3921f, 8.5422f, 16.2173f, 8.7171f)
                    curveTo(16.0425f, 8.8919f, 15.8198f, 9.0109f, 15.5773f, 9.0591f)
                    curveTo(15.3348f, 9.1074f, 15.0835f, 9.0826f, 14.8551f, 8.988f)
                    curveTo(14.6267f, 8.8934f, 14.4314f, 8.7332f, 14.2941f, 8.5276f)
                    curveTo(14.1567f, 8.3221f, 14.0834f, 8.0804f, 14.0834f, 7.8332f)
                    curveTo(14.0834f, 7.5016f, 14.2151f, 7.1837f, 14.4495f, 6.9493f)
                    curveTo(14.684f, 6.7149f, 15.0019f, 6.5832f, 15.3334f, 6.5832f)
                    close()
                }
            }
        }
            .build()
        return _storyborder!!
    }

private var _storyborder: ImageVector? = null

