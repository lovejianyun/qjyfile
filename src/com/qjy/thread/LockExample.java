package com.qjy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author qijianyun
 *锁实例
 */
public class LockExample {
	static class NumberWrapper{
		public int value = 1;
	}
	public static void main(String[] args) {
		//初始化可重入锁
		final ReentrantLock lock = new ReentrantLock();
		//第一个条件当屏幕上输出3
		final Condition reachThreecondition = lock.newCondition();
		final Condition reachSixcondition = lock.newCondition();
		final NumberWrapper num = new NumberWrapper();
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//需要先获取锁
				try {
					lock.lock();
					System.out.println("threadA");
					while(num.value <= 3) {
						System.out.println(num.value);
						num.value++;
					}
					//输出3时告诉B线程可以开始运行了
					reachThreecondition.signal();
				} finally {
					lock.unlock();
				}
				try {
					lock.lock();
					//等待输出6的数字
						
					reachSixcondition.await();
					System.out.println("threadA");
					while(num.value<=9) {
						System.out.println(num.value);
						num.value++;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					lock.lock();
					while(num.value <= 3) {
						//等待3输出完毕的信号
						reachThreecondition.await();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				try {
					lock.lock();
					//已经收到信号  开始输出4，5，6
					System.out.println("threadB");
					while(num.value <= 6) {
						System.out.println(num.value);
						num.value++;
					}
					//4,5,6输出完毕告诉A线程
					reachSixcondition.signal();
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		});
		threadA.start();
		threadB.start();
	}
}
