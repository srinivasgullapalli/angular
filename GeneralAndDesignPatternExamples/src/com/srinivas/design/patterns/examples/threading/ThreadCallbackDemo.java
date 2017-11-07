package com.srinivas.design.patterns.examples.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadCallbackDemo {
	
	public ThreadCallbackDemo()
	{
		System.out.println("Inside ThreadCallbackDemo Constructor ");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
		{
			ICallback callBack = new CallbackImpl(i+1);
			CallableTask task = new CallableTask(callBack, i+1);
			 Future<Integer> future =  executor.submit(task);
		}
		
		executor.shutdown();
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    ThreadCallbackDemo demo = new ThreadCallbackDemo();
	}

}

class CallableTask implements Callable<Integer>
{
	ICallback callBack;
	Integer item;
	public CallableTask(ICallback callBack,Integer item)
	{
	   this.item=item;
	   this.callBack= callBack;
	}
	
	public Integer call()
	{
		System.out.println("Inside the Callable Task with item  : "+item +" the thread :"+Thread.currentThread().getName());
		callBack.callBackMethod();
		return item;
	}
}

interface ICallback 
{
	public void callBackMethod();
}
class CallbackImpl implements ICallback
{
	int item;
	
	public CallbackImpl(int item)
	{
		this.item=item;
	}
	
	public void callBackMethod()
	{
		System.out.println("Inside Callback method : "+item);
	}
	
}