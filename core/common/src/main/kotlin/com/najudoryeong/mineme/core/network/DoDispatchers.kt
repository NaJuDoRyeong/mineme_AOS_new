package com.najudoryeong.mineme.core.network

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val doDispatcher: DoDispatchers)

enum class DoDispatchers {
    Default,
    IO,
}
