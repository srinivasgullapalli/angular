package com.srinivas.design.patterns.examples.threading;

import java.util.LinkedList;

public class ThreadPoolExample {
private WorkerThread[] workerThreads;
private LinkedList<Runnable> taskQueue ;


public static void main(String args[])
{
	ThreadPoolExample t = new ThreadPoolExample(5);
	t.enqueue(new RunnableTask());
	t.enqueue(new RunnableTask());
	t.enqueue(new RunnableTask());
	t.enqueue(new RunnableTask());
}
public ThreadPoolExample(int threadCount)
{
	taskQueue =  new LinkedList<Runnable>();
	workerThreads = new WorkerThread[threadCount];
	for(int i=0;i<threadCount;i++)
	{
		workerThreads[i]= new WorkerThread();
		workerThreads[i].start();
	}
}

public void enqueue(Runnable r)
{
	synchronized(taskQueue){
	taskQueue.addLast(r);
	taskQueue.notifyAll();
	}
}
class WorkerThread extends Thread
{
  public void run()
  {
	  Runnable r;
	  synchronized(taskQueue)
	  {
		  while(taskQueue.isEmpty())
		  {
			 try {
				taskQueue.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		  
		 r= (Runnable)taskQueue.removeFirst();
		 System.out.println("Element removed");
		 try{
		 r.run();
		 }
		 catch(Exception e)
		 {
			 
		 }
	  }
  }
}
}


