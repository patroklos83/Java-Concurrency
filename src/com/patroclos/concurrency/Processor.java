package com.patroclos.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Processor {

	private boolean isProducing = true;	
	private List<String> messages = new LinkedList<>();
	private final int messagesSize = 5; 

	public synchronized void produce() throws InterruptedException  {


		while(true) {
			
				while(!isProducing)
					wait();			
				
				while(messages.size() == messagesSize)
					wait();
				

				int randomNumer = (int) (1 + Math.random() * 10);
				
				System.out.println("Sending message: " + randomNumer);
				messages.add(Integer.toString(randomNumer));
				
				
				isProducing = false;
				notify();



			}

		
	}



	public synchronized void consume() throws InterruptedException  {
		
		while(true){
			
			while(isProducing)
				wait();
			
			while(messages.isEmpty())
				wait();

			int lastElementIndex = messages.size()-1;
			System.out.println("Receiving message: " + messages.get(lastElementIndex));
			messages.remove(lastElementIndex);
			
			
		    isProducing=true;
			
			Thread.sleep(1000);
			
			notify();

		}

	}

}
