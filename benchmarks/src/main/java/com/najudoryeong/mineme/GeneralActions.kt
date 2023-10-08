package com.najudoryeong.mineme

import androidx.benchmark.macro.MacrobenchmarkScope

fun MacrobenchmarkScope.setTestJwtAndStartApp(jwt: String) {
    val command = "am start -n $PACKAGE_NAME/MainActivity -e TEST_JWT $jwt"
    device.executeShellCommand(command)
}



