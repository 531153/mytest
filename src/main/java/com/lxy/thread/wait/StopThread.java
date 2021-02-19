package com.lxy.thread.wait;

import java.sql.SQLOutput;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class StopThread implements Runnable {
	private static volatile boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println(Thread.currentThread().getName() + "正在运行……");
		}
		System.out.println(Thread.currentThread().getName() + "结束运行");
	}

	private void stopThread() {
		flag = false;
	}

	public static void main(String[] args) throws Exception {
//		StopThread stopThread = new StopThread();
//		new Thread(stopThread, "A").start();
//		System.out.println("main线程在运行");
//		TimeUnit.MICROSECONDS.sleep(10);
//		stopThread.stopThread();
		cyclicBarrier();
	}


	private static void cyclicBarrier() throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread run");
				try {
					cyclicBarrier.await();
				}catch (Exception e){
					e.printStackTrace();
				}
				System.out.println("thread end do something");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread run");
				try {
					cyclicBarrier.await();
				}catch (Exception e){
					e.printStackTrace();
				}
				System.out.println("thread end do something");
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread run");
				try {
					Thread.sleep(2000);
					cyclicBarrier.await();
				}catch (Exception e){
					e.printStackTrace();
				}
				System.out.println("thread end do something");
			}
		}).start();
		System.out.println("all thread done");
	}
}
