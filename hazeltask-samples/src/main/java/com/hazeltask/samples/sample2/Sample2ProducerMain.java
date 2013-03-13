package com.hazeltask.samples.sample2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.hazelcast.core.Hazelcast;
import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.defaults.ExecutorConfigs;

public class Sample2ProducerMain {

    public static void main(String[] args) throws Exception {
        HazeltaskConfig config = new HazeltaskConfig()
            .withHazelcastInstance(Hazelcast.getDefaultInstance())
            .withTopologyName("MyTopology")
            .withExecutorConfig(
                    ExecutorConfigs.basic()
                        .withDisableWorkers(true) //we will not allow the producer to work on work
             ); 
                
        
        ExecutorService executorService = Hazeltask.newHazeltaskInstance(config).getExecutorService();
        Thread.sleep(5000);
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        System.out.println("Submitting 100 items");
        for(int i =1; i<=100; i++) {
            results.add(
               executorService.submit(new AddTenTask(i))
            );
        }
        System.out.println("Done submitting 100 items");
        
        for(Future<String> result : results) {
            System.out.println(result.get());
        }
        
        System.out.println("Done printing results!");
        
        //should print out numbers  11 through 110 and indicate the worker id they were done on
    }
    
    //TODO: make this a different type of task
    public static class AddTenTask implements Callable<String>, Serializable {
        private static final long serialVersionUID = 1L;
        
        private int i;
        
        AddTenTask(int i) {
            this.i = i;
        }
        
        public String call() throws Exception {
            Thread.currentThread().sleep(2000);
            System.out.println("work on "+i);
            return "Worker "+Hazeltask.getHazeltaskInstanceByTopology("MyTopology").getId()+" worked on: "+(this.i + 10);
        }
    }

}
