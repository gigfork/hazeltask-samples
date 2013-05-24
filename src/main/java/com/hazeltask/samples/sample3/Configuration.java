package com.hazeltask.samples.sample3;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazeltask.config.ExecutorLoadBalancingConfig;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;
import com.hazeltask.samples.sample3.Sample3ProducerMain.Priority;

public class Configuration {
    public static HazeltaskConfig getConfig() {
        Config c = new Config();
        //c.setProperty("hazelcast.initial.min.cluster.size", "2");
        HazelcastInstance hc = Hazelcast.newHazelcastInstance(c);
        
        return new HazeltaskConfig()
        .withHazelcastInstance(hc)
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
