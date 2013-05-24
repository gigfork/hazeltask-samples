package com.hazeltask.samples.sample5;

import java.io.Serializable;
import java.util.concurrent.Callable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.hazeltask.Hazeltask;
import com.hazeltask.executor.DistributedExecutorService;

public class Sample5_2Main {

    public static void main(String[] args) throws Exception {
        DistributedExecutorService<?> executorService = Hazeltask.newHazeltaskInstance(Configuration.getConfig())
                .getExecutorService();

        for(int i =1; i<=10; i++) {
            Futures.addCallback(executorService.submit(new AddTenSometimesErrorTask(i)), new FutureCallback<Integer>() {
                public void onSuccess(Integer result) {
                    System.out.println("Succes: "+result);
                }

                public void onFailure(Throwable t) {
                    System.out.println("Oh no! "+t);
                }
            });
        }
    }
    
    private static class AddTenSometimesErrorTask implements Callable<Integer>, Serializable {
        private static final long serialVersionUID = 1L;
        
        private int i;
        
        public AddTenSometimesErrorTask(int i) {
            this.i = i;
        }
        
        public Integer call() throws Exception {
           if(i%2 == 0) {
                throw new RuntimeException("Pretend error on "+i);
           }
            
           return this.i + 10;
        }
    }

}
