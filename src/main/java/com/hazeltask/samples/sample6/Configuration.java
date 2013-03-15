package com.hazeltask.samples.sample6;

import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;

public class Configuration {
    public static HazeltaskConfig getConfig() {
        return new HazeltaskConfig()
            .withTopologyName("MyTopology")
            .withExecutorConfig(ExecutorConfigs.basic().
                    /* For demo purposes, make it poll every 6 seconds to recover lost
                     * items.  The default is 30 seconds.  You should not normally do 
                     * this as checking is not super cheap.
                     */
                    withRecoveryProcessPollInterval(6000));
    }
}
