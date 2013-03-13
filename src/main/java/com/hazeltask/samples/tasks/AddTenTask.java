package com.hazeltask.samples.tasks;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class AddTenTask implements Callable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private int i;
    
    public AddTenTask(int i) {
        this.i = i;
    }
    
    public Integer call() throws Exception {
        return this.i + 10;
    }
}