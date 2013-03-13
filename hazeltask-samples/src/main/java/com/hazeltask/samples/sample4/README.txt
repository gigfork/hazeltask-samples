This example shows how to shut down the executor and get what tasks it had in it.  This is 
useful if you wanted to shut down the whole cluster and serialize the tasks to disk / database
for adding to the cluster when you startup again.

Please note that these tasks will *eventually* be automatically redistributed to other members in 
the cluster to work on.

Run this example in the same manner as sample3.