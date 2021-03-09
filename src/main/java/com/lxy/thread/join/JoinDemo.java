package com.lxy.thread.join;

public class JoinDemo extends Thread {
	int i;
	//上一个线程
	Thread previousThread;

	public JoinDemo(Thread previousThread, int i) {
		this.previousThread = previousThread;
		this.i              = i;
	}

	@Override
	public void run() {
		try {
			previousThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("num:" + i);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread previousThread = Thread.currentThread();
		System.out.println("main join");
		Thread.currentThread().join(1000);
		System.out.println("main join out");
		for (int i = 0; i < 10; i++) {
			JoinDemo joinDemo = new JoinDemo(previousThread, i);
			joinDemo.start();
			previousThread = joinDemo;
		}
		System.out.println("main thread");
	}
}
