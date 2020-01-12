# Java-Concurrency


Java project to demonstrate Concurrency basic Patterns

ConcurrencyExample
-------------------
This example makes use of the Producer-Consumer Pattern, using wait-notify operations


Producer creates messages (random numbers) and adds them to a LinkedList
Consumer consumes the last message added to the LinkedList

Note: Maximum messages to be added to the list is 5



CompletableFutureExample
------------------------

Demonstrates the use of CompletableFuture
calls a process Class to process a long lasting job (6 seconds for this example)....
After completion returns the String finished
