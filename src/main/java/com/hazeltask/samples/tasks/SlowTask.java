package com.hazeltask.samples.tasks;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class SlowTask implements Callable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private int i;
    
    public SlowTask(int i) {
        this.i = i;
    }
    
    public Integer call() throws Exception {
        Thread.sleep(1000);
        //return this.i + 10;
        return this.i;
    }
}