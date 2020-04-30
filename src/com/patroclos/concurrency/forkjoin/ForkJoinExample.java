package com.patroclos.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	int[] numbers;
	int start;
	int end;
	int threshold = 10;

	public ForkJoinExample(int[] numbers,int start,int end){
		this.numbers = numbers;
		this.start= start;
		this.end=end;			
	}


	@Override
	protected Long compute() {


		if (end-start < threshold) {
				return sum();
		}else {
			int middle = (start + end) / 2;
			 
			ForkJoinExample subTask1 = new ForkJoinExample(numbers, start, middle);
			ForkJoinExample subTask2 = new ForkJoinExample(numbers, middle, end);
 
            invokeAll(subTask1, subTask2);
 
 
            return subTask1.join() + subTask2.join();
		}
	}



	protected Long sum() {
		
		Long sum = 0L;
		 
        for (int i = start; i < end; i++) {
                sum+=numbers[i];
        }
 
        return sum;
	}
	

}
