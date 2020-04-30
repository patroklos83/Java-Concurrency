package com.patroclos.entry;

import java.util.concurrent.ForkJoinPool;

import com.patroclos.concurrency.Processor;
import com.patroclos.concurrency.forkjoin.ForkJoinExample;

public class App {

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

		//tProducer.start();
		//tConsumer.start();




		//ForkJoin Example
		int nThreads = Runtime.getRuntime().availableProcessors();
		System.out.println(nThreads);

		int[] numbers = new int[12]; 
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}

		ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
		Long result = forkJoinPool.invoke(new ForkJoinExample(numbers,0,12));
		System.out.println("ForkJoin Summation result = " + result);



	}

}
