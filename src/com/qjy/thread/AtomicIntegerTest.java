package com.qjy.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest  implements Runnable{
	private AtomicInteger i = new AtomicInteger(0);
	public int getValue() {
		return i.get();
	}
	private void evenIncrement() {
		i.addAndGet(2);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			evenIncrement();
		}
		
	}
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println("Aborting");
				System.exit(0);
			}
		}, 5000);
		ExecutorService threadPool = Executors.newCachedThreadPool();
		AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
		threadPool.execute(atomicIntegerTest);
		while(true) {
			int value = atomicIntegerTest.getValue();
			if(value % 2 != 0) {
				System.out.println(value);
				System.exit(0);
			}
		}
	}
}
