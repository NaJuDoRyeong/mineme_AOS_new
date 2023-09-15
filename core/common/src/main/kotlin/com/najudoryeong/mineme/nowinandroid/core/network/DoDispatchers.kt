package com.najudoryeong.mineme.nowinandroid.core.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val doDispatcher: DoDispatchers)

enum class DoDispatchers {
    Default,
    IO,
}
