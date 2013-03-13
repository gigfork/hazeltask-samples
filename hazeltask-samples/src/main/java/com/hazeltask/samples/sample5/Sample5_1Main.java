package com.hazeltask.samples.sample5;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.hazeltask.Hazeltask;
import com.hazeltask.executor.DistributedExecutorService;
import com.hazeltask.samples.tasks.AddTenTask;

public class Sample5_1Main {
    public static void main(String[] args) throws Exception {
        DistributedExecutorService<?,?> executorService = Hazeltask.newHazeltaskInstance(Configuration.getConfig())
                                                   .getExecutorService();
        
        for(int i =1; i<=10; i++) {
            Futures.addCallback(executorService.submit(new AddTenTask(i)), new FutureCallback<Integer>() {
                public void onSuccess(Integer result) {
                    System.out.println("Succes: "+result);
                }

                public void onFailure(Throwable t) {
                    System.out.println("Oh no! "+t);
                }
            });
        }
    }
    
    
}
