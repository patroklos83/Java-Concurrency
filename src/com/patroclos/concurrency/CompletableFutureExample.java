package com.patroclos.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

	public static void main(String[] args) {
		
		ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
		
		
		CompletableFuture<Object> future = new CompletableFuture<Object>();
		
		DoSomethingProcess process = new DoSomethingProcess();
		future = CompletableFuture.supplyAsync(process,executors);
		
		future.thenAcceptAsync((r)-> System.out.println(r),executors);
		
		
		

	}

}
