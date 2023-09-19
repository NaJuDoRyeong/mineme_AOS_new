package hilt_aggregated_deps;

import dagger.hilt.processor.internal.aggregateddeps.AggregatedDeps;
import javax.annotation.processing.Generated;

/**
 * This class should only be referenced by generated code! This class aggregates information across multiple compilations.
 */
@AggregatedDeps(
    components = "dagger.hilt.components.SingletonComponent",
    replaces = "com.najudoryeong.mineme.core.network.di.DispatchersModule",
    modules = "com.najudoryeong.mineme.core.testing.di.TestDispatchersModule"
)
@Generated("dagger.hilt.processor.internal.aggregateddeps.AggregatedDepsGenerator")
public class _com_najudoryeong_mineme_core_testing_di_TestDispatchersModule {
}
