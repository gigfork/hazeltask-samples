Hazeltask Demos
=================
These samples demonstrate the different usages and facets of the Hazeltask library.  Hazeltask runs on top of the Hazelcast partitioned peer-to-peer data distribution library.

For more information on Hazelcast:  http://www.hazelcast.com
For more information on Hazeltask:  https://github.com/jclawson/hazeltask

[Sample 1](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample1) - A simple Hazelcast ExecutorService replacement
-----------------
If you are using Hazelcast's ExecutorService to distribute tasks you may want to consider replacing it with this library.  Out of the box with no additional configuration you will get automatic task failover, no MemberLeftExceptions when waiting on a Future who's assigned member shutdown, and automatic task rebalancing across the cluster.

This sample just illustrates the bare-bones ease of use in getting started.

[Sample 2](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample2) - Producer and Consumer
-----------------
Demonstrates sending tasks from a producer who doesn't do any work to multiple consumers and reading back the results via Future.get

[Sample 3](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample3) - Task priorities
-----------------
Demonstrates task prioritization.  20 low priority tasks will be submitted, and then 4 high priority tasks.  You will see the high priority tasks take precidence over the low priority.

[Sample 4](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample4) - Shutting down the ExecutorService
-----------------
Shows the basic ExecutorService API is honored when shutting down the executor

[Sample 5](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample5) - Use Guava ListenableFutures and callbacks
-----------------
Shows how to use Guava ListenableFutures and callbacks instead of Future.get to process results from tasks

[Sample 6](https://github.com/jclawson/hazeltask-samples/tree/master/src/main/java/com/hazeltask/samples/sample6) - Failover capabilities
-----------------
Shows task failover recovery when a node godes down.  No lost work!  All futures still work!