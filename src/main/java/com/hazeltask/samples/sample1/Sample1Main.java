package com.hazeltask.samples.sample1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.hazeltask.Hazeltask;
import com.hazeltask.samples.tasks.AddTenTask;

public class Sample1Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Hazeltask.getDefaultInstance().getExecutorService();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for(int i =1; i<=10; i++) {
            results.add(
               executorService.submit(new AddTenTask(i))
            );
        }
        
        for(Future<Integer> result : results) {
            System.out.println(result.get());
        }
        
        //should print out numbers  11 through 20
    }

}
