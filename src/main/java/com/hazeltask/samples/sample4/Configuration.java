package com.hazeltask.samples.sample4;

import java.util.UUID;

import com.hazeltask.config.ExecutorLoadBalancingConfig;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;
import com.hazeltask.samples.sample4.Sample3ProducerMain.Priority;

public class Configuration {
    public static HazeltaskConfig getConfig() {
        return new HazeltaskConfig()
        .withName("MyTopology")
        .withExecutorConfig(
                ExecutorConfigs.<Priority>basicGroupable()
                    .withLoadBalancingConfig(
                         new ExecutorLoadBalancingConfig<Priority>()
                                .useEnumOrdinalPrioritizer(Priority.class)
                    )          
         );
    }
}
