package com.hazeltask.samples.sample7;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.hazeltask.Hazeltask;
import com.hazeltask.samples.tasks.SlowTask;

public class Sample7Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Hazeltask.getDefaultInstance().getExecutorService();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for(int i =0; i<10; i++) {
            results.add(
               executorService.submit(new SlowTask(i))
            );
        }

        results.get(7).cancel(true);
        results.get(9).cancel(true);
        
        
        for(Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (CancellationException c) {
                System.out.println("Cancelled");
            }
        }
        
        //should print out numbers  11 through 20 and Cancelled instead of 18 and 20
    }

}
