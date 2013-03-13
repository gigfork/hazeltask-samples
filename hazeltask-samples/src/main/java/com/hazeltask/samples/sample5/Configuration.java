package com.hazeltask.samples.sample5;

import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;

public class Configuration {
    public static HazeltaskConfig getConfig() {
        return new HazeltaskConfig()
        .withTopologyName("MyTopology")
        .withExecutorConfig(
             ExecutorConfigs.basic()
         );
    }
}
