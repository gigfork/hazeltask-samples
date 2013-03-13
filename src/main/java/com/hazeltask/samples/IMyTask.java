package com.hazeltask.samples;

import java.io.Serializable;
import java.util.concurrent.Callable;

public interface IMyTask extends Serializable, Callable<String> {
    public String getCustomerId();
}
