package com.hazeltask.samples.sample6;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;
import com.hazeltask.Hazeltask;
import com.hazeltask.config.HazeltaskConfig;

public class DyingConsumerMain {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        //this code exits the JVM 5 seconds after it sees a member connect
        Hazelcast.getDefaultInstance().getCluster().addMembershipListener(new MembershipListener() {
            public void memberRemoved(MembershipEvent membershipEvent) {}
            public void memberAdded(MembershipEvent membershipEvent) {
                System.out.println("member added... I will shutdown in 2 seconds");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                new Thread(new Runnable(){
                    public void run() {
                        System.exit(1);
                    }                    
                }).start();
            }
        });
        
        HazeltaskConfig config = Configuration.getConfig();
        Hazeltask.newHazeltaskInstance(config);
    }

}
