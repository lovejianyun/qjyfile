package com.qjy.thread;

import java.util.concurrent.TimeUnit;

public class JoinClass {
	public static void main(String[] args) throws InterruptedException {
		Thread previous = Thread.currentThread();
		for(int i=0;i<10;i++) {
			Thread thread = new Thread(new demo(previous),"线程:"+String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName()+"end");
	}
	static class demo implements Runnable{
		private Thread thread;
		
		public demo(Thread thread) {
			this.thread = thread;
		}

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(thread.currentThread().getName()+"end");
		}
		
	}
}
