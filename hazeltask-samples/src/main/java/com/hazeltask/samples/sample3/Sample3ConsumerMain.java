package com.hazeltask.samples.sample3;

import com.hazeltask.Hazeltask;
import com.hazeltask.config.ExecutorConfig;
import com.hazeltask.config.HazeltaskConfig;
import com.hazeltask.samples.sample3.Sample3ProducerMain.MyListRouterFactory;
import com.hazeltask.samples.sample3.Sample3ProducerMain.MyTaskIdAdapter;
import com.hazeltask.samples.sample3.Sample3ProducerMain.Priority;

public class Sample3ConsumerMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HazeltaskConfig config = new HazeltaskConfig()
        .withTopologyName("MyTopology")
        .withExecutorConfig(new ExecutorConfig<Long, Priority>()
            .withTaskIdAdapter(new MyTaskIdAdapter())
            .withTaskRouterFactory(new MyListRouterFactory())            
         );
        Hazeltask.newHazeltaskInstance(config);
    }

}
