package com.srinivas.design.patterns.examples.threading;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BulkTaskInAMinute {
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		System.out.println("Start time :" + startTime);
		ExecutorService executor = Executors.newFixedThreadPool(30);
		Collection<Callable<Integer>> taskList = new ArrayList<Callable<Integer>>();
		for (int i = 0; i < 1000; i++) {
			taskList.add(new TaskToBeRun(i));
		}
		executor.invokeAll(taskList);
		executor.shutdown();
		System.out.println("Time Taken is : "
				+ ((System.currentTimeMillis() - startTime) / 1000));
	}
}

class TaskToBeRun implements Callable<Integer> {
	Integer number;
	TaskToBeRun(int number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return number;
	}

}


