package com.patroclos.concurrency;

public class ConcurrencyExample {

	public static void main(String[] args) throws InterruptedException {
	
		
		Processor processor = new Processor();
		Thread tProducer = new Thread(()->{
			try {
				processor.produce();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Thread tConsumer = new Thread(()->{
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		
		tProducer.start();
		tConsumer.start();
		
		

	}

}
