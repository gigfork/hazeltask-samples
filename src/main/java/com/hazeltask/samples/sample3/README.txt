This example shows how to customize Hazeltask to run with a priority work scheduler.

Tasks will be given a priority of LOW, or HIGH.  The HIGH priority tasks will take precedence.

How to run:
1) Start one or more workers
2) wait until the worker(s) are started
3) Start 1 producer

The producer will first add 100 LOW priority tasks in the system with ids > 100.  Then,
it will add 3 HIGH priority tasks with ids: 2,3 and 4.  You should see messages on the console
of the worker indicating which tasks have been run.