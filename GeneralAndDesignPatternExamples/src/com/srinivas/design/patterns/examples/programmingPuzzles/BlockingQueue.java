package com.srinivas.design.patterns.examples.programmingPuzzles;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	  private List<Object> queue = new LinkedList<Object>();
	  private int  limit = 10;

	  public BlockingQueue(int limit){
	    this.limit = limit;
	  }


	  public synchronized void enqueue(Object item)
	  throws InterruptedException  {
	    while(this.queue.size() == this.limit) {
	      wait();
	    }
	    this.queue.add(item);
	    notifyAll();
	    System.out.println("Added elements successfully!!!!!!!!!!!!!!");
	  }


	  public synchronized Object dequeue()
	  throws InterruptedException{
		  System.out.println("Inside deque method");
	    while(this.queue.size() == 0){
	      wait();
	    }
	   Integer i= (Integer)this.queue.remove(0);
	    notifyAll();
	    return i;
	  }

	public static void main(String args[]) throws InterruptedException
	{
		BlockingQueue queue = new BlockingQueue(10);
		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
		}
		
		for(int i=0;i<10;i++)
		{
		queue.dequeue();
		System.out.println("Done");
		}
		
		
	}
	

}
