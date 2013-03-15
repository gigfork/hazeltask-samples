package com.hazeltask.samples.tasks;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class SimpleEchoTask implements Callable<Serializable>, Serializable {
    private static final long serialVersionUID = 1L;
    
    private Serializable o;
    
    public SimpleEchoTask(Serializable o) {
        this.o = o;
    }
    
    public Serializable call() throws Exception {
        System.out.println("Starting work on "+o);
        Thread.currentThread().sleep(5000);
        System.out.println("Finished work on "+o);
        return o;
    }
}