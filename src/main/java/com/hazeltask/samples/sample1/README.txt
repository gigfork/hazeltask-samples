This example shows how to use Hazeltask in the simplest manner with only default options as a 
replacement for the Hazelcast ExecutorService

In this example we separate the producer from the worker only so that its easy to see the work being 
handed out to workers.  Normally I would recommend making every node have the same config in the cluster.

To run this example:
1) Start two workers
2) Start the producer
3) Wait a few seconds, kill 1 worker
4) Observe that all the work is still completed!