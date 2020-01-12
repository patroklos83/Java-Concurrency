package com.patroclos.concurrency;

import java.util.function.Supplier;

public class DoSomethingProcess implements Supplier<Object> {

	@Override
	public Object get() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Processing takes around 6 seconds...");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return "finished";
	}

}
