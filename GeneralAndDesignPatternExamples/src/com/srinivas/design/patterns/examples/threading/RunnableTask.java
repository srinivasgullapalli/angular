package com.srinivas.design.patterns.examples.threading;

public class RunnableTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside the run method :"+Thread.currentThread().getName());
	}

}
