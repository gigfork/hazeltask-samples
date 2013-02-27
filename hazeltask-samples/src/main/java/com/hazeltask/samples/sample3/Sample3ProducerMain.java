package com.hazeltask.samples.sample3;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import com.hazeltask.Hazeltask;
import com.hazeltask.config.ExecutorConfig;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.config.helpers.AbstractTaskRouterFactory;
import com.hazeltask.core.concurrent.collections.router.ListRouter;
import com.hazeltask.core.concurrent.collections.router.LoadBalancedRouter;
import com.hazeltask.core.concurrent.collections.tracked.ITrackedQueue;
import com.hazeltask.executor.task.TaskIdAdapter;

public class Sample3ProducerMain {

    public static void main(String[] args) throws Exception {
        HazeltaskConfig config = new HazeltaskConfig()
        .withTopologyName("MyTopology")
        .withExecutorConfig(new ExecutorConfig<Long, Priority>()
            .withTaskIdAdapter(new MyTaskIdAdapter())
            .withTaskRouterFactory(new MyListRouterFactory()) 
            .disableWorkers()
         );
        ExecutorService executorService = Hazeltask.newHazeltaskInstance(config).getExecutorService();
        
        //add in a bunch of low priority tasks
        for(int i=100; i<=200; i++)
            executorService.execute(new MyTask(i, Priority.LOW));
        
        //add in a few high priority tasks
        executorService.execute(new MyTask(2, Priority.HIGH));
        executorService.execute(new MyTask(3, Priority.HIGH));
        executorService.execute(new MyTask(4, Priority.HIGH));
        
        //you will notice that the high priority tasks will take precedence over the low priority!
    }

    //comparitor to help sort priorities... lower is higher priority
    static class PriorityComparator implements Comparator<Entry<Priority, ITrackedQueue<?>>> {
        public int compare(Entry<Priority, ITrackedQueue<?>> o1, Entry<Priority, ITrackedQueue<?>> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
    }
    
    //factory that creates the router to use
    static class MyListRouterFactory extends AbstractTaskRouterFactory<Long, Priority>{
        @Override
        public ListRouter<Entry<Priority, ITrackedQueue<?>>> createTaskRouter(
                Callable<List<Entry<Priority, ITrackedQueue<?>>>> listAcessor) {
            return new LoadBalancedRouter<Map.Entry<Priority,ITrackedQueue<?>>>(listAcessor, new PriorityComparator());
        } 
    }
    
    //adapter that helps the task system identift a task (id and group)
    public static class MyTaskIdAdapter implements TaskIdAdapter<MyTask, Long, Priority> {
        public Long getTaskId(MyTask task) {
            return task.id;
        }

        public Priority getTaskGroup(MyTask task) {
            return task.priority;
        }  
    }
    
    static enum Priority {
        HIGH,
        LOW
    }
    
    //the task must always implement Serializable or dataserializable
    public static class MyTask implements Serializable, Runnable {
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           System.out.println("Worked on "+id);
        }
    }
}
