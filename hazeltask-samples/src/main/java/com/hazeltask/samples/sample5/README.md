Sample 5 - Guava ListenableFuture
=============
These samples illustrate how to leverage Google Guava's ListenableFuture interface to use callbacks instead of blocking Future.get calls.  For more information see Guava docs: https://code.google.com/p/guava-libraries/wiki/ListenableFutureExplained

Sample 5.1
-------------
Leverages the onSuccess callback


Sample 5.2
-------------
Odd numbers will trigger an exception to be thrown and the onFailure callback will be called