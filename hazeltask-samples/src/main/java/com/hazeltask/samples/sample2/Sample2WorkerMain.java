package com.hazeltask.samples.sample2;

import com.hazelcast.core.Hazelcast;
import com.hazeltask.Hazeltask;
import com.hazeltask.HazeltaskInstance;
import com.hazeltask.config.HazeltaskConfig;

public class Sample2WorkerMain {

    public static void main(String[] args) throws Exception {
        HazeltaskConfig config = new HazeltaskConfig()
            .withHazelcastInstance(Hazelcast.getDefaultInstance())
            .withTopologyName("MyTopology");
        
        HazeltaskInstance instance = Hazeltask.newHazeltaskInstance(config);
        
        System.out.println("Worker: "+instance.getId());
    }

}
