Sample6 - Task Recovery Demo
============================

This example is to simulate the task recovery process.

How to run
============================
Run the classes in this order:
1) ConsumerMain
2) DyingConsumerMain
3) ProducerMain

Explanation
============================
The DyingConsumerMain class will do a System.shutdown() after 2 seconds of seeing the producer connect (so it may start some tasks but not finish).  This is meant to get some tasks assigned to it and then die with those tasks in hand.  What you should see, is the ConsumerMain eventually pick up and run those tasks.

The ProducerMain will print out the results of the tasks once they are completed so watch his output.  The consumers will also print out which tasks they worked on.  They will show a started message, and a finished message for each task.  NOTE: the finished is just when the task thought it was done... not necessarily when it has acknowledged to the distributed system that it was done.

The recovery process poll time was decreased from its default of 30 seconds, to 6 seconds.  This is just for demo purposes.  You will likely see the recovery process run a few times.  It may take more than 1 run of the process to find and recover all the lost tasks.  This process will run on both the producer and consumer.

In the producer output, you should see "Success" for all 20 tasks after about a minute.