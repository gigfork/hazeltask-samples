package com.hazeltask.samples;

public class BarTask implements IMyTask {
    private static final long serialVersionUID = 1L;
    private String customerId;
    private String name;
    
    public BarTask(long customerId, String name) {
        this.customerId = Long.toString(customerId);
        this.name = name;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public String call() throws Exception {
        return "Bar: Hello "+name;
    }
}
