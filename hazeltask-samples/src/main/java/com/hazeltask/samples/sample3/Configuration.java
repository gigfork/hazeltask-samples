package com.hazeltask.samples.sample3;

import java.util.UUID;

import com.hazeltask.config.ExecutorLoadBalancingConfig;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;
import com.hazeltask.samples.sample3.Sample3ProducerMain.Priority;
import com.hazeltask.samples.sample3.Sample3ProducerMain.PriorityComparator;

public class Configuration {
    public static HazeltaskConfig getConfig() {
        return new HazeltaskConfig()
        .withTopologyName("MyTopology")
        .withExecutorConfig(
                ExecutorConfigs.<Priority>basicGroupable()
                    .withLoadBalancingConfig(
                         new ExecutorLoadBalancingConfig<UUID, Priority>()
                                .useComparatorTaskGroupSelection(new PriorityComparator())
                    )          
         );
    }
}
