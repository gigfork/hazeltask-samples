package com.hazeltask.samples.sample2;

import com.hazelcast.core.Hazelcast;
import com.hazeltask.Hazeltask;
import com.hazeltask.HazeltaskInstance;
import com.hazeltask.config.defaults.HazeltaskConfigs;
import com.hazeltask.config.defaults.HazeltaskConfigs.HazeltaskSimpleConfig;

public class Sample2WorkerMain {

    public static void main(String[] args) throws Exception {
        HazeltaskSimpleConfig config = HazeltaskConfigs.basic();
        config.withHazelcastInstance(Hazelcast.getDefaultInstance())
              .withName("MyTopology");
        
        HazeltaskInstance<Integer> instance = Hazeltask.newHazeltaskInstance(config);
        
        System.out.println("Worker: "+instance.getId());
    }

}
