package com.srinivas.design.patterns.examples.java7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueDemo {

	static TransferQueue<Integer> queue = new LinkedTransferQueue<Integer>();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(new LinkedTransferQueueDemo().new Producer());
		executor.submit(new LinkedTransferQueueDemo().new Consumer());
		executor.shutdown();

	}

	class Producer implements Runnable {
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("Producer is waiting to produce elements :" + i);
				try {
					LinkedTransferQueueDemo.queue.transfer(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Producer transfered : " + i);

			}
		}
	}

	class Consumer implements Runnable {
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println("Consumer is wating to consume :" + i);
					LinkedTransferQueueDemo.queue.take();
					System.out.println("Consumer consumed : " + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
