Sample6 - Future cancellation
============================

This example shows how to cancel a task via the Future.cancel method

How to run
============================
Run Sample7Main

Explanation
============================
When cancel is called on a future, it asks each member to cancel the task by task id.  Once a member has cancelled a task, a message is put on a topic that is consumed by the Future to cancel.


Note
============================
Future.cancel doesn't currently inturrupt currently executing tasks even when true is passed to the cancel method.  This feature will be added in a future release.