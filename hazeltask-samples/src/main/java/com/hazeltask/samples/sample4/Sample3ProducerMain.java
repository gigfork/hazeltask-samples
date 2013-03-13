package com.hazeltask.samples.sample4;

import java.io.Serializable;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;

import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.core.concurrent.collections.grouped.Groupable;

public class Sample3ProducerMain {

    public static void main(String[] args) throws Exception {
        HazeltaskConfig config = Configuration.getConfig();
        
        //disable workers on the producer so its easier to see work
        //being distributed to worker nodes
        config.getExecutorConfig().disableWorkers();
        
        ExecutorService executorService = Hazeltask.newHazeltaskInstance(config).getExecutorService();
        
        //add in a bunch of low priority tasks
        for(int i=100; i<=120; i++)
            executorService.execute(new MyTask(i, Priority.LOW));
        
        //add in a few high priority tasks
        executorService.execute(new MyTask(1, Priority.HIGH));
        executorService.execute(new MyTask(2, Priority.HIGH));
        executorService.execute(new MyTask(3, Priority.HIGH));
        executorService.execute(new MyTask(4, Priority.HIGH));
        
        //you will notice that the high priority tasks will take precedence over the low priority!
    }

    //comparitor to help sort priorities... lower is higher priority
    static class PriorityComparator implements Comparator<Priority> {
        public int compare(Priority o1, Priority o2) {
            return o1.compareTo(o2);
        }
    }
    
    static enum Priority {
        LOW,
        HIGH
    }
    
    //the task must always implement Serializable or dataserializable
    public static class MyTask implements Serializable, Runnable, Groupable<Priority> {
        private static final long serialVersionUID = 1L;
        
        final long id;
        final Priority priority;
        
        public MyTask(long id, Priority priority) {
            this.id = id;
            this.priority = priority;
        }

        public void run() {
           try {
               Thread.sleep(5000);
            } catch (InterruptedException e) {
                //Thread.currentThread().interrupt();
                System.out.println("Task "+id+" was interrupted");
                //return;
            }
           System.out.println("Worked on "+id);
        }

        public Priority getGroup() {
            return priority;
        }
    }
}
