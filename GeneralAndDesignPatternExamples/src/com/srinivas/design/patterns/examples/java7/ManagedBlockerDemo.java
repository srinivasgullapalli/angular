package com.srinivas.design.patterns.examples.java7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ForkJoinPool;

import com.srinivas.design.patterns.examples.threading.ForkJoinFolderProcessor;

import sun.security.provider.NativePRNG.Blocking;

public class ManagedBlockerDemo<T> implements java.util.concurrent.ForkJoinPool.ManagedBlocker {
	
	 final BlockingQueue<T> queue ;
	volatile T value = null;
	
	public T getValue()
	{
		return value;
	}
	public ManagedBlockerDemo(BlockingQueue<T> queue)
	{
		this.queue=queue;
		
	}
	
	@Override
	public boolean block() throws InterruptedException {
       if(value ==null)
       {
    	   value = queue.take();
       }
		return true;
	}


	@Override
	public boolean isReleasable() {
      
		
		return value !=null || (value =queue.poll()) !=null;
	}


	public static void main(String[] args) throws InterruptedException {
       BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(5);
       bQueue.add("a");
       bQueue.add("b");
       
       ManagedBlockerDemo<String> blocker = new ManagedBlockerDemo<String>(bQueue);
       ForkJoinPool.managedBlock(blocker);
       System.out.println(blocker.getValue());
	}
}
