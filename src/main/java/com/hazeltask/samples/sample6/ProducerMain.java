package com.hazeltask.samples.sample6;

import java.io.Serializable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.executor.DistributedExecutorService;
import com.hazeltask.samples.tasks.SimpleEchoTask;

public class ProducerMain {

    public static void main(String[] args) {
        HazeltaskConfig config = Configuration.getConfig();
        config.getExecutorConfig().disableWorkers();
        DistributedExecutorService<?,?> executorService = Hazeltask.newHazeltaskInstance(config)
                                                   .getExecutorService();
        
        System.out.println("Submitting 20 items");
        for(int i =1; i<=20; i++) {
            Futures.addCallback(executorService.submit(new SimpleEchoTask(i)), new FutureCallback<Serializable>() {
                public void onSuccess(Serializable result) {
                    System.out.println("Success: "+result);
                }

                public void onFailure(Throwable t) {
                    System.out.println("Something threw an exception???");
                    t.printStackTrace();
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
