package com.srinivas.design.patterns.examples.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceDemo implements Callable<Integer> {
	
	Integer inputOne;
	Integer inputTwo;
	Long sleepTime;
	

	public ExecutorCompletionServiceDemo(Integer inputOne, Integer inputTwo, Long sleepTime) {
		super();
		this.inputOne = inputOne;
		this.inputTwo = inputTwo;
		this.sleepTime = sleepTime;
	}



	@Override
	public Integer call() throws Exception {

		Thread.sleep(sleepTime);
		return inputOne*inputTwo;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ExecutorService executorService = Executors.newFixedThreadPool(5);
         ExecutorCompletionService< Integer> completionService = new ExecutorCompletionService<>(executorService);
         List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
         
         futures.add(completionService.submit(new ExecutorCompletionServiceDemo(2, 2, (long) 100)));  
         futures.add(completionService.submit(new ExecutorCompletionServiceDemo(300, 200, (long) 1000)));
         futures.add(completionService.submit(new ExecutorCompletionServiceDemo(344442, 20000, (long) 5000)));
         
         for(Future f : futures)
         {
        	 try
        	 {
        		 Integer result = completionService.take().get();
        		 System.out.println("Result : --->"+result);
        	 }
        	 catch(Exception e)
        	 {
        		 
        	 }
         }
         
         executorService.shutdown();
          
          
	
	}

}
