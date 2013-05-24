package com.hazeltask.samples.sample4;

import java.util.List;

import com.hazeltask.Hazeltask;
import com.hazeltask.HazeltaskInstance;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.executor.task.HazeltaskTask;
import com.hazeltask.samples.sample4.Sample4ProducerMain.MyTask;

public class Sample4ConsumerMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HazeltaskConfig config = Configuration.getConfig();
        HazeltaskInstance instance = Hazeltask.newHazeltaskInstance(config);
        
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Shutting down...");
        List<Runnable> works = instance.getExecutorService().shutdownNow();
        System.out.println("I got "+works.size()+" works");
        System.out.println("-----------------");
        for(Runnable r : works) {
            HazeltaskTask task = ((HazeltaskTask)r);
            System.out.println(((MyTask)task.getInnerRunnable()).id);
        }
        config.getHazelcast().getLifecycleService().shutdown();
    }

}
