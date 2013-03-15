package com.hazeltask.samples.sample6;

import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;

public class ConsumerMain {
    public static void main(String[] args) {
        HazeltaskConfig config = Configuration.getConfig();
        Hazeltask.newHazeltaskInstance(config);
    }
}
