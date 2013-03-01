package com.hazeltask.samples.sample3;

import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;

public class Sample3ConsumerMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HazeltaskConfig config = Configuration.getConfig();
        Hazeltask.newHazeltaskInstance(config);
    }

}
